package com.webapp.travelAgency.externalapi.model.openweather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    private long id;
    private String main;
    private String description;
    private String icon;

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
