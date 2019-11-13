package com.zahidiqbal.weather.Service;

import com.zahidiqbal.weather.model.Weather;
import com.zahidiqbal.weather.model.WeatherByZip;
import com.zahidiqbal.weather.model.WebServiceResponse;
import com.zahidiqbal.weather.model.ZipCodes;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class WeatherService  {


    private ZipCodes zipCodes;
  //  private Object data=null;

  @Autowired
  private static Logger logger;



  @Autowired
  RestTemplate restTemplate;

  private static final String url = "http://www.zipcodeapi.com/rest/N60hIzuRMId2HJ57ozt2zTxEGswAU0Tq15vcIHOhDWaVci2O1409MuWdqHZTns4R/city-zips.json/";
  private static final String owsUrl = "https://openweathermap.org/api?source=post_page";

  public ZipCodes getZipCodes(String city, String state){

      try{
          logger.info("::::::::API access Ok::::::::::");
          zipCodes = restTemplate.getForObject( url + city + "/" + state, ZipCodes.class);

          logger.debug(zipCodes.toString());
      }catch(Exception e){
          logger.error(e.getMessage());
      }
      return zipCodes;

  }
  public List<WeatherByZip> getWeatherByZip(ZipCodes zipCodes){


      String [] zipCodesArray = zipCodes.getZipCodes();
      List<String> zipCodeList = Arrays.asList(zipCodesArray);
          return zipCodeList.stream().map(zipCode -> {
             Weather weather = restTemplate.getForObject(owsUrl + zipCode, Weather.class);
             return new WeatherByZip(zipCode,weather);
          }).collect(Collectors.toList());

  }

}
