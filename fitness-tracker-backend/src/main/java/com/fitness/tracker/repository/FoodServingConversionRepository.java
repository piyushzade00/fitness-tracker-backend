package com.fitness.tracker.repository;

import com.fitness.tracker.entity.FoodServingConversion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface FoodServingConversionRepository extends JpaRepository<FoodServingConversion, Long> {

    Optional<FoodServingConversion> findByFoodNutritionIdAndServingUnitIgnoreCase(Long foodNutritionId, String servingUnit);

    List<FoodServingConversion> findByFoodNutritionId(Long foodNutritionId);
}
