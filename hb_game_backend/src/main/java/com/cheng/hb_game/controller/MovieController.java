package com.cheng.hb_game.controller;

import com.cheng.hb_game.model.Movie;
import com.cheng.hb_game.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movie")
    public Movie getMovieByTitle(@RequestParam String title) {
        Optional<Movie> movie = movieService.findByTitle(title);
        return movie.orElse(null);
    }
}
