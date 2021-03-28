package com.dunzo.interview.model;

import com.dunzo.interview.constant.IngredientStatus;
import lombok.Getter;

@Getter
public final class ProcessStatus {
    private final String ingredientName;
    private final IngredientStatus status;

    public ProcessStatus(String ingredientName, IngredientStatus status) {
        this.ingredientName = ingredientName;
        this.status = status;
    }
}
