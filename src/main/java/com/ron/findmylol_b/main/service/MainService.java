package com.ron.findmylol_b.main.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.ron.findmylol_b.common.exception.ResponseErrorHandler;
import com.ron.findmylol_b.common.util.HttpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Transactional
public class MainService {

    @Value("${x.riot.token}")
    private String token;

    public void lolApiLoadSummoner(String summonerName) {
        JsonNode jsonNode = HttpUtil.connectHttp("/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + token, HttpMethod.GET, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        System.out.println(jsonNode);
    }
}
