package com.fitness.tracker.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class MealLogRequest {
    private Long userId;
    private String mealName; // e.g. "Lunch"
    private LocalDate date;
    private List<FoodItemRequest> foods;
}