package com.webapp.travelAgency.externalapi.model.openweather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sys {
    private long type;
    private long id;
    private String country;
    private String sunrise;
    private long sunset;

    @Override
    public String toString() {
        return "Sys{" +
                "type=" + type +
                ", id=" + id +
                ", country='" + country + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset=" + sunset +
                '}';
    }
}
