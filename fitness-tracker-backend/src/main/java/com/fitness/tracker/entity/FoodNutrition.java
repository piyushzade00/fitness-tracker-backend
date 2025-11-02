package com.fitness.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="food_nutrition")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodNutrition {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String servingUnit;

    @Column(precision = 10, scale = 2)
    private Double caloriesPerServing;

    @Column(precision = 10, scale = 2)
    private Double carbsPerServing;

    @Column(precision = 10, scale = 2)
    private Double dietaryFibrePerServing;

    @Column(precision = 10, scale = 2)
    private Double sugarPerServing;

    @Column(precision = 10, scale = 2)
    private Double addedSugarsPerServing;

    @Column(precision = 10, scale = 2)
    private Double sugarAlcoholsPerServing;

    @Column(precision = 10, scale = 2)
    private Double netCarbsPerServing;

    @Column(precision = 10, scale = 2)
    private Double proteinPerServing;

    @Column(precision = 10, scale = 2)
    private Double totalFatPerServing;

    @Column(precision = 10, scale = 2)
    private Double saturatedFatPerServing;

    @Column(precision = 10, scale = 2)
    private Double transFatPerServing;

    @Column(precision = 10, scale = 2)
    private Double polyunsaturatedFatPerServing;

    @Column(precision = 10, scale = 2)
    private Double monounsaturatedFatPerServing;

    @Column(precision = 10, scale = 2)
    private Double cholesterolPerServing;

    @Column(precision = 10, scale = 2)
    private Double sodiumPerServing;

    @Column(precision = 10, scale = 2)
    private Double calciumPerServing;

    @Column(precision = 10, scale = 2)
    private Double ironPerServing;

    @Column(precision = 10, scale = 2)
    private Double potassiumPerServing;

    @Column(precision = 10, scale = 2)
    private Double vitamin_APerServing;

    @Column(precision = 10, scale = 2)
    private Double vitamin_CPerServing;

    @Column(precision = 10, scale = 2)
    private Double vitamin_DPerServing;

    private String brandName;
    private String source;    // "USDA" | "User" | "Custom"
}
