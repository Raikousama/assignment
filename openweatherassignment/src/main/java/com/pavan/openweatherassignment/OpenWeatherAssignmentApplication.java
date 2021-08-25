package com.pavan.openweatherassignment;

import com.pavan.openweatherassignment.repos.CurrentWeatherRepo;
import com.pavan.openweatherassignment.services.FetchWeatherData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpenWeatherAssignmentApplication{

	@Autowired
	private FetchWeatherData fetchWeatherData;


	@Autowired
	private CurrentWeatherRepo currentWeatherRepo;

	public static void main(String[] args) {
		SpringApplication.run(OpenWeatherAssignmentApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
