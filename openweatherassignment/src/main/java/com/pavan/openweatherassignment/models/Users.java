package com.pavan.openweatherassignment.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
public class Users {

    @Id
    private String id;

    private String userName;
    private String passwordHash;


  public Users(String userName, String passwordHash) {
    this.userName = userName;
    this.passwordHash = passwordHash;
  }
}
