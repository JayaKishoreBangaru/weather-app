package com.broadcom.prescreen.weatherapp;


import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class WeatherRestClient {

    private static final String GET_FORCAST_BY_COORDINATES ="https://api.weather.gov/points/{x},{y}/forecast";


    static RestTemplate restTemplate = new RestTemplate();
    public String callGetWeatherForecastByCoordinatesAPI(double x, double y)  {
        System.out.println("Latitude is : "+x);
        System.out.println("Longitude is : "+y);
        HttpHeaders headers = new HttpHeaders();
        Map<String, Double> param = new HashMap<>();
        param.put("x", x);
        param.put("y", y);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        String responseResult = null;
        try {
            responseResult = restTemplate.getForObject(GET_FORCAST_BY_COORDINATES, String.class, param);
        } catch (HttpClientErrorException htex) {
            responseResult = htex.getLocalizedMessage();
        } catch (Exception e) {
            responseResult = e.getLocalizedMessage();
        }

        System.out.println(responseResult);

        return responseResult;

    }

}
