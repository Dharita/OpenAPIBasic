package com.openapi.demo.delegate.implementation;

import com.openapi.demo.generated.api.UsersApiDelegate;
import com.openapi.demo.generated.model.User;
import com.openapi.demo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class UserApiDelegateImpl implements UsersApiDelegate {

    @Autowired
    IUserService userService;

    @Override
    public ResponseEntity<User> addUser(User user) {
        log.info("Add new user: {}", user);
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long userId) {
        log.info("Delete user: {}", userId);
        return (userService.deleteUser(userId)) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<User> getUserById(Long userId, String userName, String firsName) {
        log.info("Get user for Id: {}; userName: {}", userId, userName);
        return (Objects.nonNull(userService.getUser(userId, userName, firsName))) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<User>> getUsers() {
        log.info("Get users");
        return (Objects.nonNull(userService.getUsers())) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<User> updateUser(Long userId, User user) {
        log.info("Update existing user: {}; ;userId: {} ", user, userId);
        if (!userId.equals(user.getId()))
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return (Objects.nonNull(userService.updateUser(user))) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
