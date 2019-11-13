package com.zahidiqbal.weather.model;

public class WeatherByZip {

    private String zipCode;
    private Weather weather;

    public WeatherByZip(String zipCode, Weather weather) {
        this.zipCode = zipCode;
        this.weather = weather;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
