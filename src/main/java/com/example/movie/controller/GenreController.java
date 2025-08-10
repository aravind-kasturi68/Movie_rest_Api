package com.example.movie.controller;

import com.example.movie.model.Genre;
import com.example.movie.repository.GenreRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @PostMapping
    public Genre createGenre(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }
}
