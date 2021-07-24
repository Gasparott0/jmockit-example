package com.example.jmockitexample.domain.repository;

import com.example.jmockitexample.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
