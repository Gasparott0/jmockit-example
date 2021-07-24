package com.example.jmockitexample.api;

import com.example.jmockitexample.api.dto.UserDTO;
import com.example.jmockitexample.domain.model.AddressViacep;
import com.example.jmockitexample.domain.model.User;
import com.example.jmockitexample.domain.service.UserService;
import com.example.jmockitexample.domain.service.ViacepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ViacepService viacepService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserDTO userDTO) {

        var user = new User();
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setHouseNumber(userDTO.getHouseNumber());
        user.setComplement(userDTO.getComplement());

        AddressViacep addressViacep = viacepService.loadUserAddressByCep(userDTO.getCep());
        user.setCep(userDTO.getCep());
        user.setStreet(addressViacep.getLogradouro());
        user.setDistrict(addressViacep.getBairro());
        user.setLocation(addressViacep.getLocalidade());

        return ResponseEntity.ok(userService.saveUser(user));
    }
}
