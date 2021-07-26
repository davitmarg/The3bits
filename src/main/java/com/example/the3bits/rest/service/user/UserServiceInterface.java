package com.example.the3bits.rest.service.user;

import com.example.the3bits.rest.persistence.user.User;

import java.util.List;

public interface UserServiceInterface {

    public User add(User user);
    public User get(Long id);
    public List<User> getAll();
    public User update(Long id , User user);
    public List<User> delete(Long id);
    public User findByEmailOrUsername(String term);

}
