package com.ron.findmylol_b.common.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PayloadParser {

    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.registerModule(new JavaTimeModule()
                .addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("M/d/yyyy"))));
    }

    public static <T> T parse(String payload, Class<T> valueType) {
        try {
            return mapper.readValue(payload, valueType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new InvalidPayloadException("Invalid payload form");
        }
    }

}
