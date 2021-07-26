package com.example.jmockitexample;

import com.example.jmockitexample.domain.model.AddressViacep;
import com.example.jmockitexample.domain.model.User;
import com.example.jmockitexample.domain.repository.UserRepository;
import com.example.jmockitexample.domain.service.UserService;
import com.example.jmockitexample.domain.service.ViacepService;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserTests {
    private AddressViacep addressViacep;
    private User user;

    @Tested
    private UserService userService;

    @Injectable
    private ViacepService mockViacepService;

    @Injectable
    private UserRepository mockUserRepository;

    @BeforeEach
    public void init() {
        addressViacep = loadAddressViacep();
        user = loadUser();

        new Expectations() {{
            mockViacepService.loadUserAddressByCep("13186587"); result = addressViacep;
            mockUserRepository.save(user); result = user;
        }};
    }

    @Test
    public void testUserData() {
        var userResponse = userService.saveUser(user);
        assertEquals("Mateus", userResponse.getName());
    }

    @Test
    public void testUserAddress() {
        var userResponse = userService.saveUser(user);
        assertEquals("Rua Andiroba", userResponse.getStreet());
    }

    @AfterEach
    public void verify() {
        new Verifications() {{
            mockViacepService.loadUserAddressByCep("13186587");
            mockUserRepository.save(user);
        }};
    }

    private AddressViacep loadAddressViacep() {
        var addressViacep = new AddressViacep();
        addressViacep.setCep("13186-587");
        addressViacep.setLogradouro("Rua Andiroba");
        addressViacep.setComplemento("");
        addressViacep.setBairro("Jardim Nova Alvorada");
        addressViacep.setLocalidade("Hortolândia");
        addressViacep.setUf("SP");
        addressViacep.setIbge("3519071");
        addressViacep.setGia("7481");
        addressViacep.setDdd("19");
        addressViacep.setSiafi("2951");
        return addressViacep;
    }

    private User loadUser() {
        var user = new User();
        user.setId(1L);
        user.setName("Mateus");
        user.setLastName("Gasparotto");
        user.setHouseNumber("128");
        user.setComplement("A");
        user.setCep("13186587");
        user.setStreet("Rua Andiroba");
        user.setDistrict("Jardim Nova Alvorada");
        user.setLocation("Hortolândia");
        return user;
    }
}