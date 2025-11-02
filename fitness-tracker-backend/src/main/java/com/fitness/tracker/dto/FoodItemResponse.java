package com.fitness.tracker.dto;

import lombok.Data;

@Data
public class FoodItemResponse {
    private String foodName;
    private Double quantity;
    private Double totalCalories;
    private Double totalProtein;
    private Double totalCarbs;
    private Double totalFats;
}
