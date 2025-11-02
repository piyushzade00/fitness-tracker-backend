package com.fitness.tracker.service.impl;

import com.fitness.tracker.dto.FoodServingConversionRequest;
import com.fitness.tracker.dto.FoodServingConversionResponse;
import com.fitness.tracker.entity.FoodNutrition;
import com.fitness.tracker.entity.FoodServingConversion;
import com.fitness.tracker.mapper.FoodServingConversionMapper;
import com.fitness.tracker.repository.FoodNutritionRepository;
import com.fitness.tracker.repository.FoodServingConversionRepository;
import com.fitness.tracker.service.FoodServingConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServingConversionServiceImpl implements FoodServingConversionService {

    private final FoodServingConversionRepository conversionRepository;
    private final FoodNutritionRepository foodNutritionRepository;

    @Transactional
    @Override
    public FoodServingConversionResponse addConversion(FoodServingConversionRequest request) {
        if (request.getGramsEquivalent() == null || request.getGramsEquivalent() <= 0) {
            throw new IllegalArgumentException("Grams equivalent must be greater than 0.");
        }

        FoodNutrition food = foodNutritionRepository.findById(request.getFoodNutritionId())
                .orElseThrow(() -> new IllegalArgumentException("Food not found with id: " + request.getFoodNutritionId()));

        conversionRepository.findByFoodNutritionIdAndServingUnitIgnoreCase(food.getId(), request.getServingUnit())
                .ifPresent(existing -> {
                    throw new IllegalArgumentException("Conversion for this serving unit already exists.");
                });

        FoodServingConversion saved = conversionRepository.save(
                FoodServingConversionMapper.toEntity(request, food)
        );

        return FoodServingConversionMapper.toResponse(saved);
    }

    @Override
    public List<FoodServingConversionResponse> getConversionsForFood(Long foodId) {
        List<FoodServingConversion> conversions = conversionRepository.findByFoodNutritionId(foodId);
        return conversions.stream()
                .map(FoodServingConversionMapper::toResponse)
                .toList();
    }

    @Override
    public Double getGramsEquivalent(Long foodId, String unit) {
        return conversionRepository.findByFoodNutritionIdAndServingUnitIgnoreCase(foodId, unit)
                .map(FoodServingConversion::getGramsEquivalent)
                .orElseThrow(() -> new IllegalArgumentException("Conversion not found for unit: " + unit));
    }
}
