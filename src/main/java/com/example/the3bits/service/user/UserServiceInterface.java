package com.example.the3bits.service.user;

import com.example.the3bits.persistence.user.User;

import java.util.List;

public interface UserServiceInterface {

    public User add(User user);
    public User get(Long id);
    public List<User> getAll();
    public User update(Long id , User user);
    public List<User> delete(Long id);
    public User findByEmailOrUsername(String term);
    public User updateImage(Long id, String path);
}
