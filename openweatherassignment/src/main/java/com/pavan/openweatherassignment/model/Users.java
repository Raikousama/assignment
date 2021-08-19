package com.pavan.openweatherassignment.model;

import org.springframework.data.annotation.Id;


public class Users {

    @Id
    private String id;

    private String userName;
    private String lastName;
    private String passwordHash;

}
