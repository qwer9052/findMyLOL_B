package com.ron.findmylol_b.common.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpStatusCodeException;

import java.io.IOException;
import java.time.LocalDateTime;

import static com.ron.findmylol_b.common.exception.PayloadParser.parse;

@Component
public class ResponseErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        try {
            super.handleError(response);
        } catch (HttpStatusCodeException e) {
            ErrorResponse error = parse(e.getResponseBodyAsString(), ErrorResponse.class);
            if (error.code == HttpStatus.PRECONDITION_FAILED) {
                handlePreconditionFailed(error.message);
            } else if (error.code == HttpStatus.NOT_IMPLEMENTED) {
                throw new CustomException(error.message);
            }
            throw new CustomException(error.message);
        }
    }

    private void handlePreconditionFailed(String message) {
        if (message.contains("Message 1")) {
            throw new CustomException(message);
        } else if (message.contains("Message 2")) {
            throw new CustomException(message);
        }
        throw new CustomException(message);
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class ErrorResponse {
        private LocalDateTime timestamp;
        private String message;
        private HttpStatus code;
        private int status;
    }
}