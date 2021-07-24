package com.example.jmockitexample.domain.service;

import com.example.jmockitexample.domain.model.AddressViacep;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViacepService {

    public AddressViacep loadUserAddressByCep(String cep) {

        var restTemplate = new RestTemplate();
        String endpoint = "https://viacep.com.br/ws/" + cep + "/json/";

        return restTemplate.getForObject(endpoint, AddressViacep.class);

    }

}
