package com.springboot.webapp.model;

import lombok.Data;

@Data
public class Employee {

    private Integer id;

    private String firstname;

    private String lastname;

    private String mail;

    private String password;
}
