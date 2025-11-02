package com.fitness.tracker.service;

import com.fitness.tracker.entity.FoodNutrition;
import java.util.List;

public interface FoodNutritionService {

    FoodNutrition addFood(FoodNutrition food);

    List<FoodNutrition> getAllFoods();

    FoodNutrition getFoodByName(String name);
}
