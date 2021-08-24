package com.pavan.openweatherassignment.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavan.openweatherassignment.models.Cities;
import com.pavan.openweatherassignment.models.OpenWeather.Coordinate;
import com.pavan.openweatherassignment.models.OpenWeather.forecast.CurrentWeather;
import com.pavan.openweatherassignment.models.OpenWeather.forecast.WeeklyForecast;
import com.pavan.openweatherassignment.repos.CityRepo;
import com.pavan.openweatherassignment.repos.CurrentWeatherRepo;
import com.pavan.openweatherassignment.repos.WeatherRepo;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class FetchWeatherData {
  @Value("${weather.api.id}")
  private String apiId;
  @Value("${weather.api.lon}")
  private String lon;

  @Value("${weather.api.lat}")
  private String lat;


  private String openWeatherUrl= "https://api.openweathermap.org/data/2.5";

  @Autowired
  private WeatherRepo weatherRepo;

  @Autowired
  private CurrentWeatherRepo currentWeatherRepo;

  @Autowired
  private CityRepo cityRepo;

  Instant start = Instant.now();

  WebClient webClient = WebClient.create(openWeatherUrl);
//TODO Change City

//  public void refreshForecastData(String city){
//    Instant now = Instant.now();
//    cityRepo.findByCityName(city).mapNotNull(t->{
//      Coordinate coordinate = t.getCityCoords();
//      if(t != null){
//        weatherRepo.findByCityName(city).mapNotNull(c->{
//          Date fetchDate =c.getDailyForecast().get(0).getDate();
//          Duration timeElapsed = Duration.between(fetchDate.toInstant(), now);
//          if (timeElapsed.toDays() >= 1) {
//            getForecastData(String.valueOf(coordinate.getLatitude()),String.valueOf(coordinate.getLongitude()));
//          }
//          return null;
//        });
//      }else {
//        getCurrentWeatherData(city);
//      }
//      return null;
//    }).subscribe();
//  }
//
  public void refreshCurrentData(String city){
    Instant now = Instant.now();
    System.out.println("Fetched Current Data for city");
    currentWeatherRepo.findByCityName(city).doOnNext(t -> {
      Optional<Date> fetchDate = Optional.ofNullable(t.getDate());
      Duration timeElapsed = Duration.between(fetchDate.get().toInstant(), now);
      if (timeElapsed.toDays() >= 1) {
        getCurrentWeatherData(city);
        System.out.println("Fetched Current Data for city1");
      }
    });// What do add here;

  }

  public void getForecastData(String longi, String lati){
    webClient.get().uri("/onecall?lat="+ lati+ "&lon="+longi+"&exclude=hourly,current,minutely&appid="+apiId).retrieve().bodyToMono(String.class).subscribe(v ->{
      ObjectMapper mapper = new ObjectMapper();
      WeeklyForecast wf = null;
      try {
        wf = mapper.readValue(v, WeeklyForecast.class);
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }
      weatherRepo.save(wf).subscribe();
    });
  }

  public void getCurrentWeatherData(String city){
    webClient.get().uri("/weather?q="+ city +"&appid="+apiId).retrieve().bodyToMono(String.class).subscribe(v ->{
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

  public Mono<WeeklyForecast> fetchForecastData(String cityName){
     cityRepo.findByCityName(cityName).map(t->{
       Coordinate coordinate = t.getCityCoords();
       return weatherRepo.findByCityName(cityName).subscribe();
     });

    return null;
  }

//  public Mono<CurrentWeather> fetchWeatherData(String cityName){
//    refreshCurrentData(cityName);
//    return (Mono<CurrentWeather>) currentWeatherRepo.findByCityName(cityName).subscribe();
//  }

  public void refreshAfterTime() {

     Instant end = Instant.now();
    Duration timeElapsed = Duration.between(start, end);
    if (timeElapsed.toMinutes() >= 1) {
      getForecastData(lon,lat);
      start = Instant.now();
    }

  }



}


