package com.secure.hauth.service;

import com.secure.hauth.entity.UserModel;

import java.util.UUID;

public interface UserService {
    public UUID registerUser(UserModel userDTO);
}
