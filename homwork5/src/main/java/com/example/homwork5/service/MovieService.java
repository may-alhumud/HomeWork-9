package com.example.homwork5.service;

import com.example.homwork5.modle.Movie;
import com.example.homwork5.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    public List<Movie> getMovie() {
        return movieRepository.findAll();
    }

    public void add(Movie movie) {
        movieRepository.save(movie);
    }

    public void updateMovie(Movie newMovie, Integer id) {
        Movie oldMovie=movieRepository.findById(id).get();
        oldMovie.setName(newMovie.getName());
        oldMovie.setGenre(newMovie.getGenre());
        oldMovie.setRating(newMovie.getRating());
        oldMovie.setDuration(newMovie.getDuration());
        oldMovie.setLaunchDate(newMovie.getLaunchDate());
        movieRepository.save(oldMovie);

    }

    public void removeMovie(Integer id) {
        movieRepository.deleteById(id);
    }
}
