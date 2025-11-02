package com.fitness.tracker.service.impl;

import com.fitness.tracker.entity.FoodNutrition;
import com.fitness.tracker.repository.FoodNutritionRepository;
import com.fitness.tracker.service.FoodNutritionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodNutritionServiceImpl implements FoodNutritionService {

    private final FoodNutritionRepository foodNutritionRepository;

    /**
     * Adds a new food item to the master table after validation.
     */
    @Override
    @Transactional
    public FoodNutrition addFood(FoodNutrition food) {
        validateFood(food);

        // Check for duplicates
        foodNutritionRepository.findByNameIgnoreCase(food.getName())
                .ifPresent(existing -> {
                    throw new IllegalArgumentException("Food with name '" + food.getName() + "' already exists.");
                });

        // Default fields
        if (food.getSource() == null || food.getSource().isBlank()) {
            food.setSource("User");
        }

        return foodNutritionRepository.save(food);
    }

    /**
     * Fetch all food items
     */
    @Override
    public List<FoodNutrition> getAllFoods() {
        return foodNutritionRepository.findAll();
    }

    /**
     * Fetch food item by name
     */
    @Override
    public FoodNutrition getFoodByName(String name) {
        return foodNutritionRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new IllegalArgumentException("Food not found: " + name));
    }

    /**
     * Basic validation logic for nutrition data
     */
    private void validateFood(FoodNutrition food) {
        if (food.getName() == null || food.getName().isBlank()) {
            throw new IllegalArgumentException("Food name cannot be empty.");
        }

        if (food.getServingUnit() == null || food.getServingUnit().isBlank()) {
            throw new IllegalArgumentException("Serving unit is required (e.g., piece, cup, bowl).");
        }

        if (food.getCaloriesPerServing() == null || food.getCaloriesPerServing() <= 0) {
            throw new IllegalArgumentException("Calories per serving must be greater than 0.");
        }

        // Ensure at least one macro nutrient is provided
        if (allNullOrZero(food.getProteinPerServing(), food.getCarbsPerServing(), food.getTotalFatPerServing())) {
            throw new IllegalArgumentException("At least one of protein, carbs, or fat must have a value.");
        }
    }

    /**
     * Utility method to check if all three macros are null or zero
     */
    private boolean allNullOrZero(Double protein, Double carbs, Double fat) {
        return (protein == null || protein == 0)
                && (carbs == null || carbs == 0)
                && (fat == null || fat == 0);
    }
}
