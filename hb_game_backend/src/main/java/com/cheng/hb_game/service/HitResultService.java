package com.cheng.hb_game.service;

import com.cheng.hb_game.model.HitResult;
import com.cheng.hb_game.repository.HitResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HitResultService {

    @Autowired
    private HitResultRepository hitResultRepository;

    public Optional<HitResult> findByCreatedBy(String createdBy) {
        return hitResultRepository.findByCreatedBy(createdBy);
    }

    public void createAndHitResult(String createdBy, String hitResultNum) {
        HitResult hitResult = new HitResult();
        hitResult.setCreatedBy(createdBy);
        hitResult.setResult(hitResultNum);
    }
}
