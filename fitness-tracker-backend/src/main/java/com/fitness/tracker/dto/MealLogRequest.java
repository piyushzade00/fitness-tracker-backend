package com.fitness.tracker.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class MealLogRequest {
    private Long userId;
    private String mealType;
    private LocalDate date;
    private List<FoodItemRequest> foods;
}