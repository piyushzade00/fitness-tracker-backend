package com.fitness.tracker.mapper;


import com.fitness.tracker.dto.*;
import com.fitness.tracker.entity.*;

import java.util.List;
import java.util.stream.Collectors;

public class MealMapper {

    public static MealLogResponse toMealLogResponse(MealLog mealLog) {
        MealLogResponse response = new MealLogResponse();
        response.setId(mealLog.getId());
        response.setUserId(mealLog.getUserId());
        response.setMealType(mealLog.getMealType().name());
        response.setDate(mealLog.getDate());
        response.setTotalCalories(mealLog.getTotalCalories());
        response.setTotalProtein(mealLog.getTotalProtein());
        response.setTotalCarbs(mealLog.getTotalCarbs());
        response.setTotalFats(mealLog.getTotalFats());

        if (mealLog.getFoodItems() != null) {
            List<FoodItemResponse> foods = mealLog.getFoodItems().stream()
                    .map(MealMapper::toFoodItemResponse)
                    .collect(Collectors.toList());
            response.setFoodItems(foods);
        }

        return response;
    }

    public static FoodItemResponse toFoodItemResponse(MealFoodItem item) {
        FoodItemResponse dto = new FoodItemResponse();
        dto.setFoodName(item.getFoodNutrition().getName());
        dto.setQuantity(item.getQuantity());
        dto.setTotalCalories(item.getTotalCalories());
        dto.setTotalProtein(item.getTotalProtein());
        dto.setTotalCarbs(item.getTotalCarbs());
        dto.setTotalFats(item.getTotalFats());
        return dto;
    }
}