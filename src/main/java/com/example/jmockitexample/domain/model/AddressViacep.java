package com.example.jmockitexample.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
public class AddressViacep {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

}