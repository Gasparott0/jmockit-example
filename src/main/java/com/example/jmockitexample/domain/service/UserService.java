package com.example.jmockitexample.domain.service;

import com.example.jmockitexample.domain.model.AddressViacep;
import com.example.jmockitexample.domain.model.User;
import com.example.jmockitexample.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ViacepService viacepService;

    public User saveUser(User user) {

        AddressViacep addressViacep = viacepService.loadUserAddressByCep(user.getCep());
        user.setStreet(addressViacep.getLogradouro());
        user.setDistrict(addressViacep.getBairro());
        user.setLocation(addressViacep.getLocalidade());

        return userRepository.save(user);
    }
}
