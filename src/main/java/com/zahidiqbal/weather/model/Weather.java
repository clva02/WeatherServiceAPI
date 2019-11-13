package com.zahidiqbal.weather.model;

import org.springframework.http.HttpStatus;

import java.util.List;

public class Weather {

    private List<Object> weatherData;

    public List<Object> getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(List<Object> weatherData) {
        this.weatherData = weatherData;
    }
}
