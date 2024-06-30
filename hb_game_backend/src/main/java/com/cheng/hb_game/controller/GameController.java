package com.cheng.hb_game.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.cheng.hb_game.model.HitResult;
import com.cheng.hb_game.service.HitResultService;

@Controller
public class GameController {

    @Autowired
    private HitResultService hitResultService;

    @MessageMapping("/guess")
    @SendTo("/topic/guesses")
    public String processGuess(@RequestParam String createdBy) {
        Optional<HitResult> hitResult = hitResultService.findByCreatedBy(createdBy);
        System.out.println("===============================");
        System.out.println(hitResult);
        return "communicate success";
    }
}
