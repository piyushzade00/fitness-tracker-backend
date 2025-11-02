package com.fitness.tracker.mapper;

import com.fitness.tracker.dto.FoodNutritionRequest;
import com.fitness.tracker.dto.FoodNutritionResponse;
import com.fitness.tracker.entity.FoodNutrition;

public class FoodNutritionMapper {

    public static FoodNutrition toEntity(FoodNutritionRequest request) {
        FoodNutrition entity = new FoodNutrition();
        entity.setName(request.getName());
        entity.setServingUnit(request.getServingUnit());
        entity.setCaloriesPerServing(request.getCaloriesPerServing());
        entity.setCarbsPerServing(request.getCarbsPerServing());
        entity.setDietaryFibrePerServing(request.getDietaryFibrePerServing());
        entity.setSugarPerServing(request.getSugarPerServing());
        entity.setAddedSugarsPerServing(request.getAddedSugarsPerServing());
        entity.setSugarAlcoholsPerServing(request.getSugarAlcoholsPerServing());
        entity.setNetCarbsPerServing(request.getNetCarbsPerServing());
        entity.setProteinPerServing(request.getProteinPerServing());
        entity.setTotalFatPerServing(request.getTotalFatPerServing());
        entity.setSaturatedFatPerServing(request.getSaturatedFatPerServing());
        entity.setTransFatPerServing(request.getTransFatPerServing());
        entity.setPolyunsaturatedFatPerServing(request.getPolyunsaturatedFatPerServing());
        entity.setMonounsaturatedFatPerServing(request.getMonounsaturatedFatPerServing());
        entity.setCholesterolPerServing(request.getCholesterolPerServing());
        entity.setSodiumPerServing(request.getSodiumPerServing());
        entity.setCalciumPerServing(request.getCalciumPerServing());
        entity.setIronPerServing(request.getIronPerServing());
        entity.setPotassiumPerServing(request.getPotassiumPerServing());
        entity.setVitamin_APerServing(request.getVitaminAPerServing());
        entity.setVitamin_CPerServing(request.getVitaminCPerServing());
        entity.setVitamin_DPerServing(request.getVitaminDPerServing());
        entity.setBrandName(request.getBrandName());
        entity.setSource(request.getSource());
        return entity;
    }

    public static FoodNutritionResponse toResponse(FoodNutrition entity) {
        FoodNutritionResponse response = new FoodNutritionResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setServingUnit(entity.getServingUnit());
        response.setCaloriesPerServing(entity.getCaloriesPerServing());
        response.setCarbsPerServing(entity.getCarbsPerServing());
        response.setDietaryFibrePerServing(entity.getDietaryFibrePerServing());
        response.setSugarPerServing(entity.getSugarPerServing());
        response.setAddedSugarsPerServing(entity.getAddedSugarsPerServing());
        response.setSugarAlcoholsPerServing(entity.getSugarAlcoholsPerServing());
        response.setNetCarbsPerServing(entity.getNetCarbsPerServing());
        response.setProteinPerServing(entity.getProteinPerServing());
        response.setTotalFatPerServing(entity.getTotalFatPerServing());
        response.setSaturatedFatPerServing(entity.getSaturatedFatPerServing());
        response.setTransFatPerServing(entity.getTransFatPerServing());
        response.setPolyunsaturatedFatPerServing(entity.getPolyunsaturatedFatPerServing());
        response.setMonounsaturatedFatPerServing(entity.getMonounsaturatedFatPerServing());
        response.setCholesterolPerServing(entity.getCholesterolPerServing());
        response.setSodiumPerServing(entity.getSodiumPerServing());
        response.setCalciumPerServing(entity.getCalciumPerServing());
        response.setIronPerServing(entity.getIronPerServing());
        response.setPotassiumPerServing(entity.getPotassiumPerServing());
        response.setVitaminAPerServing(entity.getVitamin_APerServing());
        response.setVitaminCPerServing(entity.getVitamin_CPerServing());
        response.setVitaminDPerServing(entity.getVitamin_DPerServing());
        response.setBrandName(entity.getBrandName());
        response.setSource(entity.getSource());
        return response;
    }
}
