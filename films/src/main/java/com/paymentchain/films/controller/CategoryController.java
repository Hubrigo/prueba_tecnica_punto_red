package com.paymentchain.films.controller;

import com.paymentchain.films.entities.CategoryEntity;
import com.paymentchain.films.entities.FilmEntity;
import com.paymentchain.films.repository.CategoryRepository;
import com.paymentchain.films.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/category")
@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public List<CategoryEntity> getAllCategorys() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable Integer id) {
        Optional<CategoryEntity> movie = categoryRepository.findById(id);
        return movie.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoryEntity createCategory(@RequestBody CategoryEntity movie) {
        return categoryRepository.save(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryEntity> updateCategory(@PathVariable Integer id, @RequestBody CategoryEntity updatedCategory) {
        Optional<CategoryEntity> optionalMovie = categoryRepository.findById(id);
        if (optionalMovie.isPresent()) {
            CategoryEntity cat = optionalMovie.get();
            cat.setDescription(updatedCategory.getDescription());
            cat.setName(updatedCategory.getName());
            return ResponseEntity.ok().body(categoryRepository.save(cat));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        categoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
