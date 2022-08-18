package com.example.tacocloud.repository;

import com.example.tacocloud.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
    Optional<Ingredient> findByName(String name);
}
