package com.dunzo.interview.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public final class Outlet {

    @JsonProperty("count_n")
    int outlets;

    public Outlet(@JsonProperty("count_n")int outlets) {
        this.outlets = outlets;
    }
}
