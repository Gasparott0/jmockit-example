package com.example.jmockitexample.api;

import com.example.jmockitexample.api.dto.UserDTO;
import com.example.jmockitexample.domain.model.User;
import com.example.jmockitexample.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody UserDTO userDTO) {

        var user = new User();
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setHouseNumber(userDTO.getHouseNumber());
        user.setComplement(userDTO.getComplement());
        user.setCep(userDTO.getCep());

        return userService.saveUser(user);
    }
}
