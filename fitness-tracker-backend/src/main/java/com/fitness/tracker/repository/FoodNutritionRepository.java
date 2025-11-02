package com.fitness.tracker.repository;

import com.fitness.tracker.entity.FoodNutrition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodNutritionRepository extends JpaRepository<FoodNutrition, Long> {
    Optional<FoodNutrition> findByNameIgnoreCase(String name);
}
