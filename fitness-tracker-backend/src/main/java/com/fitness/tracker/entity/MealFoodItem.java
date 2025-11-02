package com.fitness.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "meal_food_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealFoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meal_log_id", nullable = false)
    private MealLog mealLog;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "food_nutrition_id", nullable = false)
    private FoodNutrition foodNutrition;

    private Double quantity; // e.g. 2 roti, 1 cup rice

    // Store computed values for record keeping
    private Double totalCalories;
    private Double totalProtein;
    private Double totalCarbs;
    private Double totalFats;
}
