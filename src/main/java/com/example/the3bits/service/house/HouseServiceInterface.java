package com.example.the3bits.service.house;

import com.example.the3bits.persistence.house.House;
import com.example.the3bits.persistence.user.User;

import java.util.List;

public interface HouseServiceInterface {
    House get(Long id);
    List<House> getAll();
    House add(House house);
    House update(Long id, House house);
    List<House> delete(Long id);
    List<House> getByUser(User user);
    List<House> deleteByUser(User user);

}
