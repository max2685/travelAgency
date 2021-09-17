package com.webapp.travelAgency.externalapi.model.openweather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Clouds {
    private int all;

    @Override
    public String toString() {
        return "Clouds{" +
                "all=" + all +
                '}';
    }
}
