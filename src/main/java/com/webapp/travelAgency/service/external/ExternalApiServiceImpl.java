package com.webapp.travelAgency.service.external;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webapp.travelAgency.externalapi.model.myip.MyIp;
import com.webapp.travelAgency.externalapi.model.openweather.OpenWeatherMap;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Service
public class ExternalApiServiceImpl implements ExternalApiService {

    private static final String OPEN_WEATHER_MAP_API_KEY = "474dc63fe4c366d989ce425afc283637";

    private static final String OPEN_WEATHER_MAP_ADDRESS = "http://api.openweathermap.org/data/2.5/";
    private static final String IPAPI_ADDRESS = "https://ipapi.co/";
    private static final String MYIP_ADDRESS = "https://api.myip.com";

    private static final String LOCALHOST_IP_V4 = "127.0.0.1";
    private static final String LOCALHOST_IP_V6 = "0:0:0:0:0:0:0:1";


    @Override
    public OpenWeatherMap getData(HttpServletRequest request) {
        String ip = getIpAddress(request);

        String city = getCity(ip);

        return getWeatherForCity(city);
    }

    private String getIpAddress(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        if(ip.equals(LOCALHOST_IP_V4) || ip.equals(LOCALHOST_IP_V6)) {
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(MYIP_ADDRESS, String.class);
            ObjectMapper mapper = new ObjectMapper();
            MyIp myIp = new MyIp();

            try {
                myIp = mapper.readValue(result, MyIp.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            ip = myIp.getIp();
        }
        return ip;
    }

    private String getCity(String ip) {
        RestTemplate restTemplate = new RestTemplate();
        String city = restTemplate.getForObject(IPAPI_ADDRESS + ip + "/city", String.class);
        return city;
    }

    private OpenWeatherMap getWeatherForCity(String city) {
        StringBuilder url = new StringBuilder();
        url
                .append(OPEN_WEATHER_MAP_ADDRESS)
                .append("weather?q=")
                .append(city)
                .append("&units=metric")
                .append("&appid=")
                .append(OPEN_WEATHER_MAP_API_KEY);

        RestTemplate restTemplate = new RestTemplate();
        OpenWeatherMap openWeatherMap;
        String response = restTemplate.getForObject(url.toString(), String.class);
        ObjectMapper mapper = new ObjectMapper();

        try {
            openWeatherMap = mapper.readValue(response, OpenWeatherMap.class);
        } catch (JsonProcessingException | HttpClientErrorException e) {
            return null;
        }

        return openWeatherMap;
    }
}
