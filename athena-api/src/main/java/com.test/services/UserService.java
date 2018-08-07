package com.test.services;

import com.test.domain.User;


public interface UserService {
    User get(String id);

    int create(User item);

    User login(User user);
}
