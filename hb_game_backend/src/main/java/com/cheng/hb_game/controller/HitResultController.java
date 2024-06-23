package com.cheng.hb_game.controller;

import com.cheng.hb_game.model.HitResult;
import com.cheng.hb_game.service.HitResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class HitResultController {

    @Autowired
    private HitResultService hitResultService;

    @GetMapping("/hitResult")
    public HitResult getHitResult(@RequestParam String createdBy) {
        Optional<HitResult> hitResult = hitResultService.findByCreatedBy(createdBy);
        return hitResult.orElse(null);
    }

    @PostMapping("/postHitResult")
    public String addHitResult(@RequestBody Map<String, Object> requestBody) {
        String createdBy = (String) requestBody.get("createdBy");
        String hitResultNum = (String) requestBody.get("hitResultNum");
        hitResultService.createAndHitResult(createdBy, hitResultNum);
        return "Document added successfully";
    }
}
