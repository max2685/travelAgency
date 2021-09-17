package com.webapp.travelAgency.service.external;

import com.webapp.travelAgency.externalapi.model.openweather.OpenWeatherMap;

import javax.servlet.http.HttpServletRequest;

public interface ExternalApiService {

    OpenWeatherMap getData(HttpServletRequest request);
}
