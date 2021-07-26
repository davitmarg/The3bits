package com.example.the3bits.rest.facade.user;

import com.example.the3bits.rest.converter.UserConverter;
import com.example.the3bits.rest.facade.user.model.UserRequestModel;
import com.example.the3bits.rest.facade.user.model.UserResponseModel;
import com.example.the3bits.rest.persistence.user.User;
import com.example.the3bits.rest.service.user.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFacade {

    private final UserServiceInterface userService;
    private final UserConverter userConverter;

    public UserFacade(UserServiceInterface userService, UserConverter converter) {
        this.userService = userService;
        this.userConverter = converter;
    }

    public UserResponseModel add(UserRequestModel request) {
        User user = userConverter.RequestToUser(request);
        user = userService.add(user);
        return userConverter.UserToResponse(user);
    }

    public UserResponseModel get(Long id) {
        User user = userService.get(id);
        return userConverter.UserToResponse(user);
    }

    public List<UserResponseModel> getAll() {
        List<User> all = userService.getAll();
        return all.stream().map(userConverter::UserToResponse).collect(Collectors.toList());
    }

    public UserResponseModel update(Long id, UserRequestModel request) {
        User user = userConverter.RequestToUser(request);
        user = userService.update(id, user);
        return userConverter.UserToResponse(user);
    }

    public List<UserResponseModel> delete(Long id) {
        List<User> all = userService.delete(id);
        return all.stream().map(userConverter::UserToResponse).collect(Collectors.toList());
    }

}
