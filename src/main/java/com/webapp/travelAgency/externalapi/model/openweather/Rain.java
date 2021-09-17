package com.webapp.travelAgency.externalapi.model.openweather;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rain {
    @JsonAlias("1h")
    private double oneH;

    @JsonAlias("3h")
    private double threeH;

    @Override
    public String toString() {
        return "Rain{" +
                "oneH=" + oneH +
                ", threeH=" + threeH +
                '}';
    }
}
