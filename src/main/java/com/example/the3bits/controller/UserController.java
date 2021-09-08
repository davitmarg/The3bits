package com.example.the3bits.controller;

import com.example.the3bits.facade.user.UserFacade;
import com.example.the3bits.facade.user.model.UserRequestModel;
import com.example.the3bits.facade.user.model.UserResponseModel;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    private final UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }


    @PostMapping("/user")
    /*@PreAuthorize("hasAnyAuthority('ADMIN')")*/
    public ResponseEntity<UserResponseModel> add(@RequestBody UserRequestModel request) {
        UserResponseModel response = userFacade.add(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{id}")
    /*@PreAuthorize("hasAnyAuthority('ADMIN')")*/
    public ResponseEntity<UserResponseModel> get(@PathVariable Long id) {
        UserResponseModel response = userFacade.get(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user")
    /*@PreAuthorize("hasAnyAuthority('ADMIN')")*/
    public ResponseEntity<List<UserResponseModel>> getAll() {
        List<UserResponseModel> all = userFacade.getAll();
        return ResponseEntity.ok(all);
    }

    @PutMapping("/user/{id}")
    /*@PreAuthorize("hasAnyAuthority('ADMIN')")*/
    public ResponseEntity<UserResponseModel> update(@PathVariable Long id, @RequestBody UserRequestModel request) {
        UserResponseModel response = userFacade.update(id, request);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/user/{id}")
    /*@PreAuthorize("hasAnyAuthority('ADMIN')")*/
    public ResponseEntity<List<UserResponseModel>> delete(@PathVariable Long id) {
        List<UserResponseModel> all = userFacade.delete(id);
        return ResponseEntity.ok(all);
    }


}
