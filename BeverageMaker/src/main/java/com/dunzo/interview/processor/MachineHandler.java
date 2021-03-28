package com.dunzo.interview.processor;

import com.dunzo.interview.model.ProcessStatus;

import java.util.Map;

public interface MachineHandler {

    /**
     * Adds supplied ingredients to the BeverageMachine, also used for refilling the ingredients to
     * the machine in case of any shortage
     *
     * @param ingredients ingredients needs to be added in the machine beforehand.
     */

    Map<String, Integer> addIngredientsToMachine(Map<String, Integer> ingredients);

    /**
     * prepare a selected beverage in machine on demand, it will return the status of the
     * process on the basis of ingredient availability in machine.
     *
     * @param beverageName         selected beverage required to be made
     * @param ingredientsInMachine ingredients available in machine with respect to each beverage
     * @return if all required ingredients
     * have sufficient availability, the process will has status AVAILABLE, if there is a shortage
     * of ingredient status will be INSUFFICIENT, and if ingredient is not available or missing status
     * will be UNAVAILABLE
     */

    ProcessStatus processBeverageRequest(String beverageName, Map<String, Map<String, Integer>> ingredientsInMachine);

    /**
     * track the minimum quantity of ingredient required to prepare any beverage, used to indicate
     * beverage machine that all ingredients are running low, and it has to refill with the
     * required ingredients.
     *
     * @param beverages collection and  composition required for preparing beverages
     */
    Map<String, Integer> trackMinimumQuantityRequired(Map<String, Map<String, Integer>> beverages);

}
