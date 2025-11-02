package com.fitness.tracker.controller;

import com.fitness.tracker.dto.FoodNutritionRequest;
import com.fitness.tracker.dto.FoodNutritionResponse;
import com.fitness.tracker.entity.FoodNutrition;
import com.fitness.tracker.mapper.FoodNutritionMapper;
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
    public ResponseEntity<FoodNutritionResponse> addFood(@RequestBody FoodNutritionRequest request) {
        FoodNutrition saved = foodNutritionService.addFood(FoodNutritionMapper.toEntity(request));
        return ResponseEntity.ok(FoodNutritionMapper.toResponse(saved));
    }

    @GetMapping
    public ResponseEntity<List<FoodNutritionResponse>> getAllFoods() {
        List<FoodNutrition> foods = foodNutritionService.getAllFoods();
        List<FoodNutritionResponse> responses = foods.stream()
                .map(FoodNutritionMapper::toResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{name}")
    public ResponseEntity<FoodNutritionResponse> getFoodByName(@PathVariable String name) {
        FoodNutrition food = foodNutritionService.getFoodByName(name);
        return ResponseEntity.ok(FoodNutritionMapper.toResponse(food));
    }
}