package com.example.mvcpractice2.mvc.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.mvcpractice2.mvc.model.User;

public class UserRepository {
    private static Map<String, User> users = new HashMap<>();

    public static void save(User user) {
        users.put(user.getUserId(), user);
    }

    public static Collection<User> findAll() {
        return users.values();
    }
}