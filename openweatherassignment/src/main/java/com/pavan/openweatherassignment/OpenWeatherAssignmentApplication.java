package com.pavan.openweatherassignment;

import com.pavan.openweatherassignment.models.Users;
import com.pavan.openweatherassignment.repos.CurrentWeatherRepo;
import com.pavan.openweatherassignment.repos.UserRepo;
import com.pavan.openweatherassignment.services.FetchWeatherData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpenWeatherAssignmentApplication implements CommandLineRunner {

	@Autowired
	private FetchWeatherData fetchWeatherData;


	@Autowired
	private CurrentWeatherRepo currentWeatherRepo;

	public static void main(String[] args) {
		SpringApplication.run(OpenWeatherAssignmentApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
//
//				currentWeatherRepo.deleteAll();
//				fetchWeatherData.getCurrentWeatherData("pune");
//				fetchWeatherData.getForecastData("73.8553","18.5196");
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
