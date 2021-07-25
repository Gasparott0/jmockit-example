package com.example.jmockitexample;

import com.example.jmockitexample.domain.model.AddressViacep;
import com.example.jmockitexample.domain.model.User;
import com.example.jmockitexample.domain.service.UserService;
import com.example.jmockitexample.domain.service.ViacepService;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserTests {

    @Tested
    private UserService userService;

    @Test
    public void testViacepService(@Injectable ViacepService mockViacepService) {
        new Expectations() {{

            mockViacepService.loadUserAddressByCep("13186587");
            result = loadAddressViacep();

        }};

        var user = new User();
        user.setCep("13186587");
        var userResponse = userService.saveUser(user);

        assertEquals("Jardim Nova Alvorada", userResponse.getDistrict());

        new Verifications() {{
            mockViacepService.loadUserAddressByCep("13186587");
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

}