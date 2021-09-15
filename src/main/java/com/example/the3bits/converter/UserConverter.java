package com.example.the3bits.converter;

import com.example.the3bits.facade.user.model.DefaultUserRegistrationRequest;
import com.example.the3bits.facade.user.model.UserRequestModel;
import com.example.the3bits.facade.user.model.UserResponseModel;
import com.example.the3bits.persistence.user.User;
import com.example.the3bits.persistence.user.UserRole;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


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
        //a url from s3 bucket instead
        user.setImagePath("https://www.seekpng.com/png/detail/202-2024994_profile-icon-profile-logo-no-background.png");
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
        //a url from s3 bucket instead
        user.setImagePath("https://www.seekpng.com/png/detail/202-2024994_profile-icon-profile-logo-no-background.png");
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
