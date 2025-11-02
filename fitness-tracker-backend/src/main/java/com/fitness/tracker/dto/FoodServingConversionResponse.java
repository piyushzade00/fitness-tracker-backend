package com.fitness.tracker.dto;

import lombok.Data;

@Data
public class FoodServingConversionResponse {
    private Long id;
    private Long foodNutritionId;
    private String servingUnit;
    private Double gramsEquivalent;
}
