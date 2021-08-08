package com.example.the3bits.rest.service.house;

import com.example.the3bits.rest.persistence.house.House;

import java.util.List;

public interface HouseServiceInterface {
    House get(Long id);
    List<House> getAll();
    House add(House house);
    House update(Long id, House house);
    List<House> delete(Long id);
}
