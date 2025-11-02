package com.fitness.tracker.controller;

import com.fitness.tracker.entity.FoodNutrition;
import com.fitness.tracker.service.FoodNutritionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/foods")
@RequiredArgsConstructor
public class FoodNutritionController {

    private final FoodNutritionService foodNutritionService;

    @PostMapping
    public ResponseEntity<FoodNutrition> addFood(@RequestBody FoodNutrition food) {
        return ResponseEntity.ok(foodNutritionService.addFood(food));
    }

    @GetMapping
    public ResponseEntity<List<FoodNutrition>> getAllFoods() {
        return ResponseEntity.ok(foodNutritionService.getAllFoods());
    }

    @GetMapping("/{name}")
    public ResponseEntity<FoodNutrition> getFoodByName(@PathVariable String name) {
        return ResponseEntity.ok(foodNutritionService.getFoodByName(name));
    }
}