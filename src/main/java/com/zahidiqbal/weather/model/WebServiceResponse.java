package com.zahidiqbal.weather.model;

import org.springframework.http.HttpStatus;

import java.util.List;

public class WebServiceResponse {

    private List<Weather> weathers ;
    private HttpStatus statusCode;

    public WebServiceResponse(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }
}
