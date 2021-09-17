package com.webapp.travelAgency.externalapi.model.openweather;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Snow {
    @JsonAlias("1h")
    private double oneH;

    @JsonAlias("3h")
    private double threeH;

    @Override
    public String toString() {
        return "Snow{" +
                "oneH=" + oneH +
                ", threeH=" + threeH +
                '}';
    }
}
