package com.fitness.tracker.controller;

import com.fitness.tracker.dto.FoodServingConversionRequest;
import com.fitness.tracker.dto.FoodServingConversionResponse;
import com.fitness.tracker.service.FoodServingConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food-conversions")
@RequiredArgsConstructor
public class FoodServingConversionController {

    private final FoodServingConversionService conversionService;

    @PostMapping
    public ResponseEntity<FoodServingConversionResponse> addConversion(@RequestBody FoodServingConversionRequest request) {
        return ResponseEntity.ok(conversionService.addConversion(request));
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<List<FoodServingConversionResponse>> getConversions(@PathVariable Long foodId) {
        return ResponseEntity.ok(conversionService.getConversionsForFood(foodId));
    }
}
