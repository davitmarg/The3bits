package com.example.the3bits.service.house.implementation;

import com.example.the3bits.persistence.house.House;
import com.example.the3bits.persistence.house.HouseRepository;
import com.example.the3bits.persistence.user.User;
import com.example.the3bits.service.house.HouseServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseServiceInterface {
    private final HouseRepository houseRepository;

    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public House get(Long id) {
        return houseRepository.getById(id);
    }

    @Override
    public List<House> getAll() {
        return houseRepository.findAll();
    }

    @Override
    public House add(House house) {
        return houseRepository.save(house);
    }

    @Override
    public House update(Long id, House house) {
        House byId = houseRepository.getById(id);
        byId.setRoomCount(house.getRoomCount());
        byId.setMaxPersonCount(house.getMaxPersonCount());
        byId.setBuildingType(house.getBuildingType());
        byId.setAddress(house.getAddress());
        return houseRepository.save(byId);
    }

    @Override
    public List<House> delete(Long id) {
        houseRepository.deleteById(id);
        return houseRepository.findAll();
    }

    @Override
    public List<House> getByUser(User user) {
        return houseRepository.findAllByUser(user);
    }
}
