package com.fitness.tracker.dto;

import lombok.Data;

@Data
public class FoodNutritionResponse {
    private Long id;
    private String name;
    private String servingUnit;

    private Double caloriesPerServing;
    private Double carbsPerServing;
    private Double dietaryFibrePerServing;
    private Double sugarPerServing;
    private Double addedSugarsPerServing;
    private Double sugarAlcoholsPerServing;
    private Double netCarbsPerServing;

    private Double proteinPerServing;

    private Double totalFatPerServing;
    private Double saturatedFatPerServing;
    private Double transFatPerServing;
    private Double polyunsaturatedFatPerServing;
    private Double monounsaturatedFatPerServing;

    private Double cholesterolPerServing;
    private Double sodiumPerServing;
    private Double calciumPerServing;
    private Double ironPerServing;
    private Double potassiumPerServing;
    private Double vitaminAPerServing;
    private Double vitaminCPerServing;
    private Double vitaminDPerServing;

    private String brandName;
    private String source;
}
