package com.zahidiqbal.weather;

import com.zahidiqbal.weather.Controller.WeatherController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WeatherApplication {

	@Bean
	public RestTemplate getRestTemplate() {

		return new RestTemplate();
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext =  SpringApplication.run(WeatherApplication.class, args);
		WeatherController weatherController = applicationContext.getBean(WeatherController.class);

	}




}
