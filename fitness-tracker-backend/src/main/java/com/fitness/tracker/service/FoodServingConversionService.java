package com.fitness.tracker.service;

import com.fitness.tracker.dto.FoodServingConversionRequest;
import com.fitness.tracker.dto.FoodServingConversionResponse;

import java.util.List;

public interface FoodServingConversionService {

    FoodServingConversionResponse addConversion(FoodServingConversionRequest request);

    List<FoodServingConversionResponse> getConversionsForFood(Long foodId);

    Double getGramsEquivalent(Long foodId, String unit);
}
