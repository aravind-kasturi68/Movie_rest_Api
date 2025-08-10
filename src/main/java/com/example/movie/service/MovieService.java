package com.example.movie.service;

import com.example.movie.model.Movie;
import com.example.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository repo;

    public MovieService(MovieRepository repo) {
        this.repo = repo;
    }

    public List<Movie> getAllMovies() {
        return repo.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return repo.findById(id);
    }

    public Movie createMovie(Movie movie) {
        return repo.save(movie);
    }

    public Movie updateMovie(Long id, Movie updated) {
        Movie movie = repo.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
        movie.setTitle(updated.getTitle());
        movie.setReleaseYear(updated.getReleaseYear());
        movie.setRating(updated.getRating());
        movie.setGenre(updated.getGenre());
        movie.setDirector(updated.getDirector());
        return repo.save(movie);
    }

    public void deleteMovie(Long id) {
        repo.deleteById(id);
    }
}
