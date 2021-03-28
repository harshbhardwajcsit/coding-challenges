package com.dunzo.interview.processor;

import java.util.Map;

public class IngredientIndicator implements Runnable {
    private final Map<String, Integer> minQuantityIngredients;
    private final Map<String, Integer> machineIngredients;


    public IngredientIndicator(Map<String, Integer> minQuantityIngredients, Map<String, Integer> machineIngredients) {
        this.minQuantityIngredients = minQuantityIngredients;
        this.machineIngredients = machineIngredients;

    }

    @Override
    public void run() {
        while (true) {
            this.machineIngredients.forEach((key, value) -> {
                if (value < this.minQuantityIngredients.get(key)) {
                    synchronized (System.out) {
//                        System.out.println(MessageFormat.format(MessageConstant.LOW_INGREDIENT_WARNING, key));
                    }
                }
            });
        }
    }
}
