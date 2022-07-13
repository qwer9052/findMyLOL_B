package com.ron.findmylol_b.main.controller;

import com.ron.findmylol_b.common.util.HttpUtil;
import com.ron.findmylol_b.main.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/summoner/{param}")
    public ResponseEntity<?> adcreveMain(@PathVariable("param") String summonerName) {
        System.out.println("asdasdsadasdsadsa");
        System.out.println("summonerName : " + summonerName);
        mainService.lolApiLoadSummoner(summonerName);
        //
        //return ResponseEntity.status(200).body(new CommonSuccessResponseDto("200", "제안 수락",  adminService.saveProposalIsAccept(dto)));
        return ResponseEntity.status(200).body(null);
    }

}
