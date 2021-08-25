package com.pavan.openweatherassignment.models;

import com.pavan.openweatherassignment.models.openweather.Coordinate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Cities {

  @Id
  private String cityName;
  private Coordinate cityCoords;

}
