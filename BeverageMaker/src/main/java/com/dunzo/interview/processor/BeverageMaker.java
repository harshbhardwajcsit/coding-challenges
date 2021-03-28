package com.dunzo.interview.processor;

import com.dunzo.interview.constant.MessageConstant;
import com.dunzo.interview.exception.UnknownBeverageException;
import com.dunzo.interview.model.ProcessStatus;

import java.text.MessageFormat;
import java.util.Map;

public class BeverageMaker implements Runnable {

    private final Map<String, Map<String, Integer>> beverages;
    private final String selectedBeverage;

    public BeverageMaker(Map<String, Map<String, Integer>> beverages, String selectedBeverage) {
        this.beverages = beverages;
        this.selectedBeverage = selectedBeverage;
    }

    private void createBeverage() {
        final ProcessStatus status = new MachineManager().processBeverageRequest(selectedBeverage, beverages);
        switch (status.getStatus()) {
            case AVAILABLE:
                synchronized (System.out) {
                    System.out.println(selectedBeverage + " is prepared");
                }
                break;
            case UNAVAILABLE:
                synchronized (System.out) {
                    System.out.println(selectedBeverage + " cannot be prepared because " + status.getIngredientName() + " is not available");
                }
                break;
            case INSUFFICIENT:
                synchronized (System.out) {
                    System.out.println(selectedBeverage + " cannot be prepared because " + status.getIngredientName() + " is not sufficient");
                }
                break;
        }
    }

    @lombok.SneakyThrows
    @Override
    public void run() {
        if (beverages.containsKey(selectedBeverage)) {
            createBeverage();
        } else {
            throw new UnknownBeverageException(MessageFormat.format(MessageConstant.UNKNOWN_BEVERAGE, selectedBeverage));
        }
    }
}
