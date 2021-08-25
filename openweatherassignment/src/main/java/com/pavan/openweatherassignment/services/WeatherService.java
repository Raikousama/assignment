package com.pavan.openweatherassignment.services;

import com.pavan.openweatherassignment.dto.CurrentWeatherDto;
import com.pavan.openweatherassignment.dto.WeatherForecastDto;
import com.pavan.openweatherassignment.models.openweather.forecast.CurrentWeather;
import com.pavan.openweatherassignment.models.openweather.forecast.WeeklyForecast;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface WeatherService {
  Mono<CurrentWeatherDto> getWeatherDetailsByCity (String city);

  Mono<WeatherForecastDto> getForecastDetailsByCity(String city);
}
