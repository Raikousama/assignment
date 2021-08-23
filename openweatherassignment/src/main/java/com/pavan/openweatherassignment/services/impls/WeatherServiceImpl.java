package com.pavan.openweatherassignment.services.impls;

import com.pavan.openweatherassignment.services.FetchWeatherData;
import com.pavan.openweatherassignment.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {
@Autowired
private FetchWeatherData fetchWeatherData;
//TODO remove hardcode
  @Override
  public void getCurrentWeather() {
     fetchWeatherData.getCurrentWeatherData("pune");
  }

  @Override
  public void getSevenDayForecast() {
    fetchWeatherData.getForecastData("73.8553","18.5196");
  }



}
