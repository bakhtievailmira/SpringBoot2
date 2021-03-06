package com.example.springboot2.service;

import com.example.springboot2.dao.UserRepository;
import com.example.springboot2.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional
    @Override
    public void save(User user) {
        userRepository.save(user);
    }


    @Transactional
    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }


    @Transactional
    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }
}
