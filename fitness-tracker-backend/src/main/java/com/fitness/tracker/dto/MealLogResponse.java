package com.fitness.tracker.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class MealLogResponse {
    private Long id;
    private Long userId;
    private String mealType;
    private LocalDate date;
    private Double totalCalories;
    private Double totalProtein;
    private Double totalCarbs;
    private Double totalFats;
    private List<FoodItemResponse> foodItems;
}