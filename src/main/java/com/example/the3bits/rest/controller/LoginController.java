package com.example.the3bits.rest.controller;

import com.example.the3bits.rest.facade.user.UserFacade;
import com.example.the3bits.rest.facade.user.model.DefaultUserRegistrationRequest;
import com.example.the3bits.rest.facade.user.model.UserResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final UserFacade userFacade;

    public LoginController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }


    @PostMapping("/register")
    public ResponseEntity<UserResponseModel> register(@RequestBody DefaultUserRegistrationRequest request) {
        UserResponseModel response = userFacade.add(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/login")
    public ResponseEntity<UserResponseModel> login(Authentication authentication) {
        Long id = userFacade.getIdByAuthentication(authentication);
        return ResponseEntity.ok(userFacade.get(id));
    }
}
