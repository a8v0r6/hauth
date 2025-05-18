package com.secure.hauth.service;

import com.secure.hauth.entity.UserModel;
import com.secure.hauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UUID registerUser(UserModel userDTO) {
        return userRepository.save(userDTO).getId();
    }
}
