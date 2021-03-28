package com.dunzo.interview;


import com.dunzo.interview.exception.UnknownBeverageException;
import com.dunzo.interview.model.BeverageMachine;
import com.dunzo.interview.processor.BeverageMaker;
import com.dunzo.interview.processor.IngredientIndicator;
import com.dunzo.interview.processor.MachineManager;
import com.dunzo.interview.utility.TestUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BeverageMakerTest {

    private BeverageMachine machine;

    @Before
    public void initialize() throws Exception {
        machine = objectMapper.readValue((TestUtility.getFileAsString("src/main/resources/input.txt")), BeverageMachine.class);
        final Map<String, Integer> machineIngredients = new  MachineManager().addIngredientsToMachine(machine.getItems());
        final Map<String, Integer> minQuantityIngredients = new MachineManager().trackMinimumQuantityRequired(machine.getBeverages());

        //Thread for watching ingredient with low quantity
        final Thread ingredientIndicator = new Thread(new IngredientIndicator(minQuantityIngredients, machineIngredients));
        ingredientIndicator.setName("MACHINE_INDICATOR");
        ingredientIndicator.start();

    }

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testForMachineStarter() throws IOException {
        final ExecutorService executorService = Executors.newFixedThreadPool(machine.getOutlet().getOutlets());
        executorService.execute(new BeverageMaker(machine.getBeverages(), "green_tea"));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "hot_coffee"));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "hot_tea"));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "black_tea"));
    }

    @Test
    public void testForIntermediateRefill1() throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(machine.getOutlet().getOutlets());
        executorService.execute(new BeverageMaker(machine.getBeverages(), "hot_tea"));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "black_tea"));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "green_tea"));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "hot_coffee"));
        new MachineManager().addIngredientsToMachine(Collections.singletonMap("hot_water", 200));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "hot_tea"));
    }

    @Test
    public void testForIntermediateRefill2() throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(machine.getOutlet().getOutlets());
        executorService.execute(new BeverageMaker(machine.getBeverages(), "hot_tea"));
        new MachineManager().addIngredientsToMachine(Collections.singletonMap("green_mixture", 300));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "black_tea"));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "green_tea"));
        new MachineManager().addIngredientsToMachine(Collections.singletonMap("green_mixture", 200));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "hot_coffee"));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "hot_tea"));
    }

    @Test
    public void testForIntermediateRefill3() throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(machine.getOutlet().getOutlets());
        executorService.execute(new BeverageMaker(machine.getBeverages(), "hot_tea"));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "black_tea"));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "green_tea"));
        new MachineManager().addIngredientsToMachine(Collections.singletonMap("tea_leaves_syrup", 500));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "hot_coffee"));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "hot_tea"));
    }

    @Test(expected = UnknownBeverageException.class)
    public void testForUnknownBeverageRequest() throws Exception, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(machine.getOutlet().getOutlets());
        executorService.execute(new BeverageMaker(machine.getBeverages(), "hot_caramel_water"));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "hot_coffee"));
    }

    @Test
    public void testForAddingNewBeverage() throws Exception, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(machine.getOutlet().getOutlets());
        final Map<String, Integer> mockIngredients = new HashMap<>();
        mockIngredients.put("hot_water", 20);
        mockIngredients.put("caramel_syrup", 10);
        machine.getBeverages().put("hot_caramel_water", mockIngredients);
        executorService.execute(new BeverageMaker(machine.getBeverages(), "hot_caramel_water"));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "hot_coffee"));
    }

    @Test
    public void testForLowIngredientsWarningAndRefillProcess() throws Exception, InterruptedException {
        final Map<String, Integer> machineIngredients = new  MachineManager().addIngredientsToMachine(machine.getItems());
        ExecutorService executorService = Executors.newFixedThreadPool(machine.getOutlet().getOutlets());

        executorService.execute(new BeverageMaker(machine.getBeverages(), "green_tea"));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "hot_coffee"));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "hot_tea"));
        executorService.execute(new BeverageMaker(machine.getBeverages(), "black_tea"));
    }

}
