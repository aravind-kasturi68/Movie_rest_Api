package com.example.movie.controller;

import com.example.movie.model.Director;
import com.example.movie.repository.DirectorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directors")
public class DirectorController {

    private final DirectorRepository directorRepository;

    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @GetMapping
    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    @PostMapping
    public Director createDirector(@RequestBody Director director) {
        return directorRepository.save(director);
    }
}
