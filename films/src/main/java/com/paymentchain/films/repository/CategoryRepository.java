package com.paymentchain.films.repository;

import com.paymentchain.films.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
}
