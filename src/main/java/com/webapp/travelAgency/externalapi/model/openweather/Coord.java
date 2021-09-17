package com.webapp.travelAgency.externalapi.model.openweather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coord {
    private double lon;
    private double lat;

    @Override
    public String toString() {
        return "Coord{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
