package com.example.the3bits.controller;

import com.example.the3bits.facade.user.UserFacade;
import com.example.the3bits.facade.user.model.DefaultUserRegistrationRequest;
import com.example.the3bits.facade.user.model.UserResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
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
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<UserResponseModel> login(Authentication authentication) {
        Long id = userFacade.getIdByAuthentication(authentication);
        return ResponseEntity.ok(userFacade.get(id));
    }
}
