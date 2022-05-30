package com.example.homwork5.controller;

import com.example.homwork5.modle.Movie;
import com.example.homwork5.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity getUser(){
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovie());
    }

    @PostMapping
    public ResponseEntity addMovie(@RequestBody @Valid Movie movie){
        movieService.add(movie);
        return ResponseEntity.status(HttpStatus.OK).body("user Added!");
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMovie(@RequestBody @Valid Movie movie ,@PathVariable Integer id){
        movieService.updateMovie(movie,id);
        return ResponseEntity.status(HttpStatus.OK).body("user Updated!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id){
        movieService.removeMovie(id);
        return ResponseEntity.status(HttpStatus.OK).body("user Deleted!");
    }

}
