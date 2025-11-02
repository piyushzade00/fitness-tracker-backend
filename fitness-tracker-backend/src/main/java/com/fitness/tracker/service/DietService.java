package com.fitness.tracker.service;

import com.fitness.tracker.dto.MealLogRequest;
import com.fitness.tracker.dto.MealLogResponse;

import java.time.LocalDate;
import java.util.List;

public interface DietService {

    MealLogResponse addMeal(MealLogRequest request);

    List<MealLogResponse> getMealsByDate(Long userId, LocalDate date);
}
