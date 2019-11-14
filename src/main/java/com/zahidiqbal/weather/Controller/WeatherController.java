package com.zahidiqbal.weather.Controller;

import com.zahidiqbal.weather.Service.WeatherService;
import com.zahidiqbal.weather.model.WeatherByZip;
import com.zahidiqbal.weather.model.WebServiceResponse;
import com.zahidiqbal.weather.model.ZipCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController

public class WeatherController {


    private ZipCodes zipCodes;
    private static final String url = "https://www.zipcodeapi.com/rest/XiNR9zX9GNRtMw9RwRXfRaQLQoNnsO5OtI2YZBLyGFHWfvtyrZLLTRI5slW4UwVn/city-zips.json/";


    @Autowired
    WeatherService weatherService;

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping( value="/weather", method = RequestMethod.POST, headers = "accept=Application/json")
    public List<WeatherByZip> getWeather(@RequestBody Map<String, String> payload)
            throws Exception {
        String cityName = payload.get("city");
        String state = payload.get("State");
     //validation logic here. call to validation object

     zipCodes =  weatherService.getZipCodes(cityName,state);

     return weatherService.getWeatherByZip(zipCodes);

    }

}
