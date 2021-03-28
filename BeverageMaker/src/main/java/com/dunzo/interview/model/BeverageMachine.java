package com.dunzo.interview.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;

import java.util.Map;

@Getter
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName(value = "machine")
public final class BeverageMachine {

    @JsonProperty("outlets")
    private final Outlet outlet;

    @JsonProperty("total_items_quantity")
    private final Map<String, Integer> items;

    @JsonProperty("beverages")
    private final Map<String, Map<String, Integer>> beverages;

    public BeverageMachine(@JsonProperty("outlets") Outlet outlet,
                           @JsonProperty("total_items_quantity") Map<String, Integer> items,
                           @JsonProperty("beverages") Map<String, Map<String, Integer>> beverages) {
        this.outlet = outlet;
        this.items = items;
        this.beverages = beverages;
    }
}
