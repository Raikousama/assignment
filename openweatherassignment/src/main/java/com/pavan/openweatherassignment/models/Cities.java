package com.pavan.openweatherassignment.models;

import com.pavan.openweatherassignment.models.OpenWeather.Coordinate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@NoArgsConstructor
public class Cities {

  @Id
  private String id;
  @Indexed(unique=true)
  private String cityName;
  private Coordinate cityCoords;

}
