package com.example.the3bits.rest.converter;

import com.example.the3bits.rest.facade.user.model.UserRequestModel;
import com.example.the3bits.rest.facade.user.model.UserResponseModel;
import com.example.the3bits.rest.persistence.user.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

    public User RequestToUser(UserRequestModel request){

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());
        user.setRole(request.getRole());
        return user;
    }
    public UserResponseModel UserToResponse(User user){
        UserResponseModel response = new UserResponseModel();
        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setUsername(user.getUsername());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setRole(user.getRole());
        return response;
    }

}
