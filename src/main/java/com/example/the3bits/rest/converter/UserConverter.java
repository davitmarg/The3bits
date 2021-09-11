package com.example.the3bits.rest.converter;

import com.example.the3bits.rest.facade.user.model.DefaultUserRegistrationRequest;
import com.example.the3bits.rest.facade.user.model.UserRequestModel;
import com.example.the3bits.rest.facade.user.model.UserResponseModel;
import com.example.the3bits.rest.persistence.user.User;
import com.example.the3bits.rest.persistence.user.UserRole;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

@Service
public class UserConverter {

    public User toUser(UserRequestModel request){
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());
        user.setImagePath("C:\\Users\\User\\Desktop\\uploads\\Enums.PNG");
        user.setRole(request.getRole());
        return user;
    }

    public User toUser(DefaultUserRegistrationRequest request){
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());
        user.setImagePath("C:\\Users\\User\\Desktop\\uploads\\Enums.PNG");
        user.setRole(UserRole.USER);
        return user;
    }


    public UserResponseModel toResponse(User user){
        UserResponseModel response = new UserResponseModel();
        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setUsername(user.getUsername());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setImagePath(user.getImagePath());
        response.setRole(user.getRole());
        return response;
    }

}
