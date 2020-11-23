package com.openapi.demo.service.implementation;

import com.openapi.demo.generated.model.User;
import com.openapi.demo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService implements IUserService {

    @Override
    public User createUser(User user) {
        log.info("User created");
        return new User();
    }

    @Override
    public List<User> getUsers() {
        log.info("Users listed");
        return new ArrayList<>();
    }

    @Override
    public User getUser(long userId, String userName, String firsName) {
        log.info("User listed");
        return new User();
    }

    @Override
    public User updateUser(User user) {
        log.info("User updated");
        return new User();
    }

    @Override
    public boolean deleteUser(long userId) {
        log.info("User deleted");
        return Boolean.TRUE;
    }
}
