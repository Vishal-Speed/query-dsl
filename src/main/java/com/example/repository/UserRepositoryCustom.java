package com.example.repository;

import com.example.entity.User;

import java.util.List;

public interface UserRepositoryCustom{
    List<User> findByName(String name);

    List<User> findAdults();

    List<User> findUserByNameAndAge(String name, Integer age);
}
