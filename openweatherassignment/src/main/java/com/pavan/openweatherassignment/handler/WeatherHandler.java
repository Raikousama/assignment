package com.pavan.openweatherassignment.handler;

import com.pavan.openweatherassignment.models.openweather.forecast.CurrentWeather;
import com.pavan.openweatherassignment.models.openweather.forecast.WeeklyForecast;
import com.pavan.openweatherassignment.services.WeatherService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class WeatherHandler {

  private final WeatherService weatherService;

  public WeatherHandler(WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  public Mono<ServerResponse> weatherDetailsByCity(ServerRequest serverRequest){
    String city="pune";
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(weatherService.getWeatherDetailsByCity(city).log(),
        CurrentWeather.class);
  }
  public Mono<ServerResponse> forecastDetailsByCity(ServerRequest serverRequest){
    String city="pune";
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(weatherService.getForecastDetailsByCity(city).log(),
        WeeklyForecast.class);

  }

}
