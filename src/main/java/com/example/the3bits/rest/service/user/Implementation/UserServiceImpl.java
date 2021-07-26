package com.example.the3bits.rest.service.user.Implementation;

import com.example.the3bits.rest.persistence.user.User;
import com.example.the3bits.rest.persistence.user.UserRepository;
import com.example.the3bits.rest.service.user.UserServiceInterface;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long id, User user) {
        User userById = userRepository.getById(id);
        userById.setFirstName(user.getFirstName());
        userById.setLastName(user.getLastName());
        userById.setEmail(user.getEmail());
        userById.setUsername(user.getUsername());
        userById.setPassword(user.getPassword());
        userById.setPhoneNumber(user.getPhoneNumber());
        userById.setRole(user.getRole());
        return userRepository.save(userById);
    }

    @Override
    public List<User> delete(Long id) {
        userRepository.deleteById(id);
        return userRepository.findAll();
    }

    @Override
    public User findByEmailOrUsername(String term) {
        return userRepository.findByUsername(term);
    }
}
