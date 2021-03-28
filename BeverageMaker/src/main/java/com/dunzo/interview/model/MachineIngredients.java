package com.dunzo.interview.model;

import java.util.Map;

public class MachineIngredients {
    public static void addToMachine(String ingredientName, Integer quantity, Map<String, Integer> ingredients) {
        if (ingredients.containsKey(ingredientName)) {
            ingredients.replace(ingredientName, ingredients.get(ingredientName) + quantity);
        } else {
            ingredients.put(ingredientName, quantity);
        }
    }

    public static void trackMinimumQuantity(Map<String, Integer> requiredIngredients, Map<String, Integer> minIngredients) {
        requiredIngredients.forEach((k, v) -> {
            if (minIngredients.containsKey(k)) {
                if (v < minIngredients.get(k)) {
                    minIngredients.replace(k, v);
                }
            } else {
                minIngredients.put(k, v);
            }
        });
    }
}
