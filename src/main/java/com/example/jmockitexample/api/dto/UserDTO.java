package com.example.jmockitexample.api.dto;

import lombok.Data;

@Data
public class UserDTO {

    private String name;
    private String lastName;
    private String houseNumber;
    private String complement;
    private String cep;
}
