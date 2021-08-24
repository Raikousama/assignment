package com.pavan.openweatherassignment.services.impls;

import com.pavan.openweatherassignment.dto.WeatherDto;
import com.pavan.openweatherassignment.models.OpenWeather.forecast.CurrentWeather;
import com.pavan.openweatherassignment.models.OpenWeather.forecast.WeeklyForecast;
import com.pavan.openweatherassignment.repos.CityRepo;
import com.pavan.openweatherassignment.repos.CurrentWeatherRepo;
import com.pavan.openweatherassignment.repos.WeatherRepo;
import com.pavan.openweatherassignment.services.FetchWeatherData;
import com.pavan.openweatherassignment.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.modelmapper.ModelMapper;


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

//
//  @Override
//  public Mono<CurrentWeather> getCurrentWeather(String cityName) {
//     return fetchWeatherData.fetchWeatherData(cityName);
//  }
//
//  @Override
//  public Mono<WeeklyForecast> getSevenDayForecast(String cityName) {
////    Mono<Cities> city = cityRepo.findByCityName(cityName);
////
////    Coordinate cityCoords = Objects.requireNonNull(city.block()).getCityCoords();
//    return fetchWeatherData.fetchForecastData(String.valueOf(cityName));
//  }

  @Override
  public Flux<WeeklyForecast> findAll() {
    fetchWeatherData.refreshAfterTime();
    return weatherRepository.findAll();
  }

  @Override
  public Mono<CurrentWeather> createWeatherDetails(Mono<CurrentWeather> currentWeatherMono) {
    fetchWeatherData.refreshAfterTime();
    return currentWeatherMono.flatMap(currentWeatherRepo::save).map(m -> modelMapper.map(m,CurrentWeather.class));
  }

  @Override
  public Mono<WeeklyForecast> createForecastDetails(Mono<WeeklyForecast> weeklyForecastMono) {
    fetchWeatherData.refreshAfterTime();
    return weeklyForecastMono.flatMap(weatherRepository::save).map(m -> modelMapper.map(m,WeeklyForecast.class));
  }

  @Override
  public Mono<WeeklyForecast> updateForecastDetails(String id, Mono<WeeklyForecast> weatherDto) {
    fetchWeatherData.refreshAfterTime();
    return weatherRepository.findById(id)
        .flatMap(result ->
            weatherDto.map(m -> modelMapper.map(m, WeeklyForecast.class)).flatMap(weatherRepository::save)
        );
  }

  @Override
  public Mono<CurrentWeather> updateWeatherDetails(String id,Mono<CurrentWeather> weatherDto) {
    fetchWeatherData.refreshAfterTime();
    return weatherRepository.findById(id)
        .flatMap(result ->
            weatherDto.map(m -> modelMapper.map(m, CurrentWeather.class)).flatMap(currentWeatherRepo::save)
        );
  }

  @Override
  public Mono<CurrentWeather> getWeatherDetailsByCity(String city) {
    System.out.println("In get Weather details by city");
    fetchWeatherData.refreshCurrentData(city);
    return currentWeatherRepo.findByCityName(city).doOnNext(System.out::println).map(m -> modelMapper.map(m, CurrentWeather.class));
  }

  @Override
  public Mono<Void> deleteWeatherDetailsById(String id) {
    fetchWeatherData.refreshAfterTime();
    return currentWeatherRepo.deleteById(id);
  }

  @Override
  public Mono<WeeklyForecast> getForecastDetailsByCity(String city) {
    fetchWeatherData.refreshAfterTime();
    return weatherRepository.findByCityName(city).map(m -> modelMapper.map(m, WeeklyForecast.class));

  }

  @Override
  public Mono<Void> deleteForecastDetailsById(String id) {
    fetchWeatherData.refreshAfterTime();
    return weatherRepository.deleteById(id);
  }


}
