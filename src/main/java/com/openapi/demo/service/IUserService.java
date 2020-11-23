package com.openapi.demo.service;

import com.openapi.demo.generated.model.User;

import java.util.List;

public interface IUserService {

    User createUser(User user);

    List<User> getUsers();

    User getUser(long userId, String userName, String firstName);

    User updateUser(User user);

    boolean deleteUser(long userId);

}
