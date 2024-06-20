package com.cheng.hb_game.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cheng.hb_game.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
}
