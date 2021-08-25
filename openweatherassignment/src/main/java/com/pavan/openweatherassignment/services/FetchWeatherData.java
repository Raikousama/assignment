package com.pavan.openweatherassignment.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavan.openweatherassignment.models.Cities;
import com.pavan.openweatherassignment.models.openweather.forecast.CurrentWeather;
import com.pavan.openweatherassignment.models.openweather.forecast.WeeklyForecast;
import com.pavan.openweatherassignment.repos.CityRepo;
import com.pavan.openweatherassignment.repos.CurrentWeatherRepo;
import com.pavan.openweatherassignment.repos.WeatherRepo;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FetchWeatherData {

  @Value("${weather.api.id}")
  private String apiId;

  private String openWeatherUrl = "https://api.openweathermap.org/data/2.5";

  @Autowired
  private WeatherRepo weatherRepo;

  @Autowired
  private CurrentWeatherRepo currentWeatherRepo;

  @Autowired
  private CityRepo cityRepo;

  Instant start = Instant.now();

  WebClient webClient = WebClient.create(openWeatherUrl);

  public void refreshCurrentData(String city) {
    getCurrentWeatherData(city);
  }

  public void refreshForecastData(String city) {
    cityRepo.findByCityName(city).doOnNext(foreCastCity ->
         getForecastData(String.valueOf(foreCastCity.getCityCoords().getLongitude()),
          String.valueOf(foreCastCity.getCityCoords().getLatitude()), city)
    ).subscribe();
  }

  public void getForecastData(String longi, String lati, String cityName) {
    webClient.get().uri(
        "/onecall?lat=" + lati + "&lon=" + longi + "&exclude=hourly,current,minutely&appid="
            + apiId).retrieve().bodyToMono(String.class).subscribe(v -> {
      ObjectMapper mapper = new ObjectMapper();
      WeeklyForecast wf = null;
      try {
        wf = mapper.readValue(v, WeeklyForecast.class);
        wf.setCityName(cityName);

      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }
      weatherRepo.save(wf).subscribe();
    });
  }

  public void getCurrentWeatherData(String city) {
    webClient.get().uri("/weather?q=" + city + "&appid=" + apiId).retrieve()
        .bodyToMono(String.class).subscribe(v -> {
          ObjectMapper mapper = new ObjectMapper();
          CurrentWeather cw = null;
          Cities newCity = new Cities();
          try {
            cw = mapper.readValue(v, CurrentWeather.class);
            newCity.setCityCoords(cw.getCoordinate());
            newCity.setCityName(city);

          } catch (JsonProcessingException e) {
            e.printStackTrace();
          }
          currentWeatherRepo.save(cw).subscribe();
          cityRepo.save(newCity).subscribe();
        });
  }

  public Mono<WeeklyForecast> fetchForecastData(String cityName) {
    cityRepo.findByCityName(cityName).map(t ->
       weatherRepo.findByCityName(cityName).subscribe()).subscribe();
    return Mono.just(new WeeklyForecast());
  }
}


