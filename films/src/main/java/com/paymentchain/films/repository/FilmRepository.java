package com.paymentchain.films.repository;

import com.paymentchain.films.entities.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<FilmEntity,Integer> {



}
