package ari.nuryadi.testingbackend.service;

import ari.nuryadi.testingbackend.entity.dto.UserDto;
import ari.nuryadi.testingbackend.entity.model.User;

import java.util.List;

public interface UserService extends TestingBackendService<UserDto, User> {
    User getEntityByEmail(String email);

    void sumPoint();

    void getRangking();
}
