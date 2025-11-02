package com.fitness.tracker.dto;

import lombok.Data;

@Data
public class FoodServingConversionRequest {
    private Long foodNutritionId;
    private String servingUnit;
    private Double gramsEquivalent;
}
