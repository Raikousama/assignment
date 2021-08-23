package com.pavan.openweatherassignment.services;

import org.springframework.stereotype.Service;

@Service
public interface WeatherService {

  void getCurrentWeather();
  void getSevenDayForecast();
}
