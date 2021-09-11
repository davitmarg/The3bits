package com.example.the3bits.rest.facade.user;

import com.example.the3bits.config.MyUserDetails;
import com.example.the3bits.rest.converter.UserConverter;
import com.example.the3bits.rest.facade.user.model.DefaultUserRegistrationRequest;
import com.example.the3bits.rest.facade.user.model.UserRequestModel;
import com.example.the3bits.rest.facade.user.model.UserResponseModel;
import com.example.the3bits.rest.persistence.user.User;
import com.example.the3bits.rest.service.user.UserServiceInterface;
import org.springframework.security.core.Authentication;
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

    public Long getIdByAuthentication(Authentication authentication) {
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        return userDetails.getId();
    }

    public UserResponseModel add(DefaultUserRegistrationRequest request) {
        User user = userConverter.toUser(request);
        user = userService.add(user);
        return userConverter.toResponse(user);
    }

    public UserResponseModel add(UserRequestModel request) {
        User user = userConverter.toUser(request);
        user = userService.add(user);
        return userConverter.toResponse(user);
    }

    public UserResponseModel get(Long id) {
        User user = userService.get(id);
        return userConverter.toResponse(user);
    }

    public List<UserResponseModel> getAll() {
        List<User> all = userService.getAll();
        return all.stream().map(userConverter::toResponse).collect(Collectors.toList());
    }

    public UserResponseModel update(Long id, UserRequestModel request) {
        User user = userConverter.toUser(request);
        user = userService.update(id, user);
        return userConverter.toResponse(user);
    }
    public UserResponseModel updateImage(Long id, String path){
        User user = userService.updateImage(id, path);
        return userConverter.toResponse(user);
    }

    public List<UserResponseModel> delete(Long id) {
        List<User> all = userService.delete(id);
        return all.stream().map(userConverter::toResponse).collect(Collectors.toList());
    }

}
