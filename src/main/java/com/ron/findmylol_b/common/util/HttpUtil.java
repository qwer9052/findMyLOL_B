package com.ron.findmylol_b.common.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class HttpUtil {


    private static final String uri = "https://kr.api.riotgames.com";

    public static JsonNode connectHttp(String targetUrl, HttpMethod method, String mediaType) {
        System.out.println("uri + targetUrl : " + uri + targetUrl);

        JsonNode jsonNode = null;


        HttpHeaders requestHeaders = new HttpHeaders();
        //requestHeaders.setContentType(MediaType.valueOf(mediaType));
        //requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //requestHeaders.add("X-Riot-Token", token);
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> respEntity = restTemplate.exchange(uri + targetUrl + "e", method, requestEntity, String.class);

        System.out.println(respEntity);

//			ObjectMapper objectMapper = new ObjectMapper();
//			jsonNode = objectMapper.readTree(respEntity.getBody());
        System.out.println(jsonNode);


        return jsonNode;
    }

}