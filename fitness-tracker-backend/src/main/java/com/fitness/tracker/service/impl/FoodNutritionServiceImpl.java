package com.fitness.tracker.service.impl;

import com.fitness.tracker.entity.FoodNutrition;
import com.fitness.tracker.repository.FoodNutritionRepository;
import com.fitness.tracker.service.FoodNutritionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodNutritionServiceImpl implements FoodNutritionService {

    private final FoodNutritionRepository foodNutritionRepository;

    @Override
    public FoodNutrition addFood(FoodNutrition food) {
        return foodNutritionRepository.save(food);
    }

    @Override
    public List<FoodNutrition> getAllFoods() {
        return foodNutritionRepository.findAll();
    }

    @Override
    public FoodNutrition getFoodByName(String name) {
        return foodNutritionRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new IllegalArgumentException("Food not found: " + name));
    }
}
