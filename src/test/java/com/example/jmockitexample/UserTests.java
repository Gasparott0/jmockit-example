package com.example.jmockitexample;

import com.example.jmockitexample.api.UserController;
import com.example.jmockitexample.domain.service.UserService;
import com.example.jmockitexample.domain.service.ViacepService;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTests {

    @Tested
    private UserController userController;

    @Mocked
    private UserService mockUserService;

    @Mocked
    ViacepService mockViacepService;

    @Test
    public void seila() {

        new Expectations() {{
            mockViacepService.loadUserAddressByCep("13186587"); result = null;
            mockUserService.saveUser(null); result = null;
        }};

    }

}
