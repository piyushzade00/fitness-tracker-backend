package com.fitness.tracker.dto;

import lombok.Data;

@Data
public class FoodItemRequest {
    private String foodName;
    private Double quantity;
}
