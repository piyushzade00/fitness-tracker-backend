package com.fitness.tracker.controller;

import com.fitness.tracker.dto.MealLogRequest;
import com.fitness.tracker.dto.MealLogResponse;
import com.fitness.tracker.service.DietService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/diet")
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;

    /**
     * Add a new meal log for a user.
     * Example: POST /api/v1/diet/add-meal
     */
    @PostMapping("/add-meal")
    public ResponseEntity<MealLogResponse> addMeal(@RequestBody MealLogRequest request) {
        MealLogResponse response = dietService.addMeal(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Get all meals for a user on a specific date.
     * Example: GET /api/v1/diet/1/2025-11-02
     */
    @GetMapping("/{userId}/{date}")
    public ResponseEntity<List<MealLogResponse>> getMealsByDate(
            @PathVariable Long userId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<MealLogResponse> meals = dietService.getMealsByDate(userId, date);
        return ResponseEntity.ok(meals);
    }
}
