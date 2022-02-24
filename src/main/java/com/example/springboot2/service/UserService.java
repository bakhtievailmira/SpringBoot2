package com.example.springboot2.service;


import com.example.springboot2.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    @Transactional
    void save(User user);

    @Transactional
    List<User> findAll();

    @Transactional
    void deleteById(long id);

    @Transactional
    User findById(long id);
}
