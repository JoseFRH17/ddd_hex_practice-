package com.jose.dddhexpractice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/champion")
public class ChampionController {

    @GetMapping("/all")
    public String getAllChampions(){
        return "[]";
    }
}
