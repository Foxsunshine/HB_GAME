package com.cheng.hb_game.service;

import com.cheng.hb_game.model.Movie;
import com.cheng.hb_game.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Optional<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }
}
