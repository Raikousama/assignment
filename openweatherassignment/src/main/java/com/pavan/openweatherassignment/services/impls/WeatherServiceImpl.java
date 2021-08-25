package com.pavan.openweatherassignment.services.impls;

import com.pavan.openweatherassignment.dto.CurrentWeatherDto;
import com.pavan.openweatherassignment.dto.WeatherForecastDto;
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



  @Override
  public Mono<CurrentWeatherDto> getWeatherDetailsByCity(String city) {
    fetchWeatherData.refreshCurrentData(city);
    return currentWeatherRepo.findByCityName(city).map(m -> modelMapper.map(m, CurrentWeatherDto.class));
  }

  @Override
  public Mono<WeatherForecastDto> getForecastDetailsByCity(String city) {
    fetchWeatherData.refreshForecastData(city);
    return weatherRepository.findByCityName(city).map(m -> modelMapper.map(m, WeatherForecastDto.class));
  }


}
