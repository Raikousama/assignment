package com.pavan.openweatherassignment.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import com.pavan.openweatherassignment.handler.WeatherHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ApiRouter {

  @Bean
  public RouterFunction<ServerResponse> routerFunction(WeatherHandler handler) {
    return RouterFunctions.route(GET("/functional/weather").and(accept(MediaType.APPLICATION_JSON)),
        handler::weatherDetailsByCity)
        .andRoute(GET("/functional/forecast").and(accept(MediaType.APPLICATION_JSON)),
            handler::forecastDetailsByCity);
  }


}
