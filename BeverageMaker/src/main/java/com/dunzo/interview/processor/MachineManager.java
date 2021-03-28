package com.dunzo.interview.processor;

import com.dunzo.interview.constant.IngredientStatus;
import com.dunzo.interview.model.MachineIngredients;
import com.dunzo.interview.model.ProcessStatus;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class MachineManager implements MachineHandler {

    private static final Map<String, Integer> ingredientsInMachine = new ConcurrentHashMap<>();
    private static final Map<String, Integer> minQuantityRequiredForIngredients = new ConcurrentHashMap<>();


    @Override
    public Map<String, Integer> addIngredientsToMachine(Map<String, Integer> ingredients) {
        ingredients.forEach((key, value) -> MachineIngredients.addToMachine(key, value, ingredientsInMachine));
        return ingredientsInMachine;
    }

    @Override
    public Map<String, Integer> trackMinimumQuantityRequired(Map<String, Map<String, Integer>> beverages) {
        beverages.forEach((key, value) -> MachineIngredients.trackMinimumQuantity(value, minQuantityRequiredForIngredients));
        return minQuantityRequiredForIngredients;
    }

    @Override
    public ProcessStatus processBeverageRequest(String beverageName, Map<String, Map<String, Integer>> beverages) {
        final Map<String, Integer> contentsRequiredForBeverage = beverages.get(beverageName);
        AtomicReference<ProcessStatus> trackProgress = new AtomicReference<>(new ProcessStatus(beverageName, IngredientStatus.AVAILABLE));
        contentsRequiredForBeverage.forEach((k, v) -> {
            trackProgress.set(prepareBeverage(k, v));
        });
        return trackProgress.get();
    }

    private static ProcessStatus prepareBeverage(String ingredient, Integer quantityRequired) {
        while (getIngredientAvailability(ingredient).isPresent() && getIngredientAvailability(ingredient).get() >= quantityRequired) {
            synchronized (ingredientsInMachine.get(ingredient)) {
                updateIngredientInMachine(ingredient, quantityRequired);
//                trackLowIngredients(ingredient);
                return new ProcessStatus(ingredient, IngredientStatus.AVAILABLE);
            }
        }
//        trackLowIngredients(ingredient);
        return ingredientsInMachine.containsKey(ingredient) ?
                new ProcessStatus(ingredient, IngredientStatus.INSUFFICIENT) :
                new ProcessStatus(ingredient, IngredientStatus.UNAVAILABLE);
    }

    private static Optional<Integer> getIngredientAvailability(String ingredient) {
        return Optional.ofNullable(ingredientsInMachine.get(ingredient));
    }

    private static Optional<Integer> getMinimumQuantity(String ingredient) {
        return Optional.ofNullable(minQuantityRequiredForIngredients.get(ingredient));
    }

    private static void updateIngredientInMachine(String ingredient, Integer quantityRequired) {
        synchronized (ingredientsInMachine.get(ingredient)) {
            final Integer updatedVolume = getIngredientAvailability(ingredient).get() - quantityRequired;
            ingredientsInMachine.put(ingredient, updatedVolume);
        }
    }

}
