package com.pavan.openweatherassignment.services.impl;

import com.pavan.openweatherassignment.models.openweather.forecast.CurrentWeather;
import com.pavan.openweatherassignment.models.openweather.forecast.WeeklyForecast;
import com.pavan.openweatherassignment.repos.CityRepo;
import com.pavan.openweatherassignment.repos.CurrentWeatherRepo;
import com.pavan.openweatherassignment.repos.WeatherRepo;
import com.pavan.openweatherassignment.services.FetchWeatherData;
import com.pavan.openweatherassignment.services.WeatherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class WeatherServiceImpl implements WeatherService {

  @Autowired
  private FetchWeatherData fetchWeatherData;
  @Autowired
  private CityRepo cityRepo;
  @Autowired
  private WeatherRepo weatherRepository;
  @Autowired
  private CurrentWeatherRepo currentWeatherRepo;
  @Autowired
  private ModelMapper modelMapper;

  //TODO Add Lombok SL4J log & Handler and Router
  public WeatherServiceImpl(
      FetchWeatherData fetchWeatherData, CityRepo cityRepo,
      WeatherRepo weatherRepository,
      CurrentWeatherRepo currentWeatherRepo, ModelMapper modelMapper) {
    this.fetchWeatherData = fetchWeatherData;
    this.cityRepo = cityRepo;
    this.weatherRepository = weatherRepository;
    this.currentWeatherRepo = currentWeatherRepo;
    this.modelMapper = modelMapper;
  }

  @Override
  public Mono<CurrentWeather> getWeatherDetailsByCity(String city) {
    return currentWeatherRepo.findByCityName(city).doFirst(new Runnable() {
          @Override
          public void run() {
            fetchWeatherData.getCurrentWeatherData(city);
          }
        }).log("getWeatherDetailsByCity")
        .doOnSuccess(m -> modelMapper.map(m, CurrentWeather.class));
  }

  @Override
  public Mono<WeeklyForecast> getForecastDetailsByCity(String city) {

    return weatherRepository.findByCityName(city).doFirst(new Runnable() {
          @Override
          public void run() {
            fetchWeatherData.refreshForecastData(city);
          }
        }).log("getForecastDetailsByCity")
        .doOnSuccess(m -> modelMapper.map(m, WeeklyForecast.class));
  }


}
