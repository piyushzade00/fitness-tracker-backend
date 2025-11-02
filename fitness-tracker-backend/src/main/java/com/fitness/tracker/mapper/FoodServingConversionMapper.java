package com.fitness.tracker.mapper;

import com.fitness.tracker.dto.FoodServingConversionRequest;
import com.fitness.tracker.dto.FoodServingConversionResponse;
import com.fitness.tracker.entity.FoodServingConversion;
import com.fitness.tracker.entity.FoodNutrition;

public class FoodServingConversionMapper {

    public static FoodServingConversion toEntity(FoodServingConversionRequest request, FoodNutrition food) {
        FoodServingConversion entity = new FoodServingConversion();
        entity.setFoodNutrition(food);
        entity.setServingUnit(request.getServingUnit());
        entity.setGramsEquivalent(request.getGramsEquivalent());
        return entity;
    }

    public static FoodServingConversionResponse toResponse(FoodServingConversion entity) {
        FoodServingConversionResponse response = new FoodServingConversionResponse();
        response.setId(entity.getId());
        response.setFoodNutritionId(entity.getFoodNutrition().getId());
        response.setServingUnit(entity.getServingUnit());
        response.setGramsEquivalent(entity.getGramsEquivalent());
        return response;
    }
}
