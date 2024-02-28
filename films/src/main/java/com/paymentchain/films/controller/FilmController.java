package com.paymentchain.films.controller;

import com.paymentchain.films.entities.FilmEntity;
import com.paymentchain.films.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/movies")
@RestController
public class FilmController {

    @Autowired
    FilmRepository filmRepository;

    @GetMapping
    public List<FilmEntity> getAllMovies() {
        return filmRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmEntity> getMovieById(@PathVariable Integer id) {
        Optional<FilmEntity> movie = filmRepository.findById(id);
        return movie.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public FilmEntity createMovie(@RequestBody FilmEntity movie) {
        return filmRepository.save(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmEntity> updateMovie(@PathVariable Integer id, @RequestBody FilmEntity updatedMovie) {
        Optional<FilmEntity> optionalMovie = filmRepository.findById(id);
        if (optionalMovie.isPresent()) {
            FilmEntity movie = optionalMovie.get();
            movie.setTitle(updatedMovie.getTitle());
            movie.setDescription(updatedMovie.getDescription());
            movie.setYear(updatedMovie.getYear());
            movie.setRentalDuration(updatedMovie.getRentalDuration());
            movie.setRating(updatedMovie.getRating());
            movie.setDuration(updatedMovie.getDuration());
            movie.setRentalPrice(updatedMovie.getRentalPrice());
            return ResponseEntity.ok().body(filmRepository.save(movie));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        filmRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
