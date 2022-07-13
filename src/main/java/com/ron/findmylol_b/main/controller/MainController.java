package com.ron.findmylol_b.main.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/home")
    public ResponseEntity<?> adcreveMain(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("asdasdsadasdsadsa");
        //return ResponseEntity.status(200).body(new CommonSuccessResponseDto("200", "제안 수락",  adminService.saveProposalIsAccept(dto)));
        return ResponseEntity.status(200).body(null);
    }

}
