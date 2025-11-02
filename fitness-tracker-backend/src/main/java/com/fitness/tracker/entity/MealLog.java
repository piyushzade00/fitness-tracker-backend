package com.fitness.tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "meal_entry")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // user link (later replace with @ManyToOne when User entity added)
    private String mealName; // e.g. Breakfast, Lunch, Dinner
    private LocalDate date;  // when meal was taken

    @OneToMany(mappedBy = "mealLog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MealFoodItem> foodItems;

    // Totals
    private Double totalCalories;
    private Double totalProtein;
    private Double totalCarbs;
    private Double totalFats;
}
