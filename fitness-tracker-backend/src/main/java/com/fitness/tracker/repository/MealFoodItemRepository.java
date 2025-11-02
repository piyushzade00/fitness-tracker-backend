package com.fitness.tracker.repository;

import com.fitness.tracker.entity.MealFoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealFoodItemRepository extends JpaRepository<MealFoodItem, Long> {
}
