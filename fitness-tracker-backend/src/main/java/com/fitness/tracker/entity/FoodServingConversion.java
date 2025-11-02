package com.fitness.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "food_serving_conversion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodServingConversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_nutrition_id", nullable = false)
    private FoodNutrition foodNutrition;

    @Column(nullable = false)
    private String servingUnit;  // e.g., cup, tablespoon, piece, gram

    @Column(nullable = false, precision = 10, scale = 2)
    private Double gramsEquivalent; // how many grams are in one serving unit
}
