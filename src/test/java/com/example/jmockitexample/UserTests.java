package com.example.jmockitexample;

import com.example.jmockitexample.domain.service.UserService;
import mockit.Mocked;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

public class UserTests {

    @Mocked
    private UserService mockedUserService;

    @BeforeTestMethod
    public void beforeMethod() {

    }
}
