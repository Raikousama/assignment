package com.pavan.openweatherassignment.controllers;

import com.pavan.openweatherassignment.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class ApiController {

  @Autowired
  private WeatherService weatherService;




}
