package com.cheng.hb_game.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cheng.hb_game.model.HitResult;

public interface HitResultRepository extends MongoRepository<HitResult, String> {
    Optional<HitResult> findByCreatedBy(String createdBy);
}
