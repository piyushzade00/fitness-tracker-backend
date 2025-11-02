package com.fitness.tracker.service.impl;

import com.fitness.tracker.dto.*;
import com.fitness.tracker.entity.*;
import com.fitness.tracker.enums.MealType;
import com.fitness.tracker.mapper.MealMapper;
import com.fitness.tracker.repository.*;
import com.fitness.tracker.service.DietService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DietServiceImpl implements DietService {

    private final MealLogRepository mealLogRepository;
    private final MealFoodItemRepository mealFoodItemRepository;
    private final FoodNutritionRepository foodNutritionRepository;

    @Transactional
    @Override
    public MealLogResponse addMeal(MealLogRequest request) {

        // Parse meal type safely
        MealType mealType;
        try {
            mealType = MealType.valueOf(request.getMealType().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid meal type: " + request.getMealType());
        }

        // Create MealLog
        MealLog mealLog = new MealLog();
        mealLog.setUserId(request.getUserId());
        mealLog.setMealType(mealType);
        mealLog.setDate(request.getDate());

        List<MealFoodItem> foodItems = new ArrayList<>();

        double totalCalories = 0;
        double totalProtein = 0;
        double totalCarbs = 0;
        double totalFats = 0;

        // Iterate foods from request
        for (FoodItemRequest foodReq : request.getFoods()) {
            FoodNutrition nutrition = foodNutritionRepository
                    .findByNameIgnoreCase(foodReq.getFoodName())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Food not found: " + foodReq.getFoodName()));

            double qty = foodReq.getQuantity();
            double calories = (nutrition.getCaloriesPerServing() != null ? nutrition.getCaloriesPerServing() : 0) * qty;
            double protein = (nutrition.getProteinPerServing() != null ? nutrition.getProteinPerServing() : 0) * qty;
            double carbs = (nutrition.getCarbsPerServing() != null ? nutrition.getCarbsPerServing() : 0) * qty;
            double fats = (nutrition.getTotalFatPerServing() != null ? nutrition.getTotalFatPerServing() : 0) * qty;

            // Build MealFoodItem
            MealFoodItem item = new MealFoodItem();
            item.setMealLog(mealLog);
            item.setFoodNutrition(nutrition);
            item.setQuantity(qty);
            item.setTotalCalories(calories);
            item.setTotalProtein(protein);
            item.setTotalCarbs(carbs);
            item.setTotalFats(fats);

            foodItems.add(item);

            // Aggregate meal totals
            totalCalories += calories;
            totalProtein += protein;
            totalCarbs += carbs;
            totalFats += fats;
        }

        // Set totals and attach list
        mealLog.setFoodItems(foodItems);
        mealLog.setTotalCalories(totalCalories);
        mealLog.setTotalProtein(totalProtein);
        mealLog.setTotalCarbs(totalCarbs);
        mealLog.setTotalFats(totalFats);

        // Save meal (cascade will save food items)
        MealLog savedMeal = mealLogRepository.save(mealLog);

        // Return DTO
        return MealMapper.toMealLogResponse(savedMeal);
    }

    @Override
    public List<MealLogResponse> getMealsByDate(Long userId, LocalDate date) {
        List<MealLog> meals = mealLogRepository.findByUserIdAndDate(userId, date);
        return meals.stream().map(MealMapper::toMealLogResponse).toList();
    }
}
