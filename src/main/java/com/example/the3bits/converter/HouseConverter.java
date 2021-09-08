package com.example.the3bits.converter;

import com.example.the3bits.facade.house.model.HouseRequestModel;
import com.example.the3bits.facade.house.model.HouseResponseModel;
import com.example.the3bits.persistence.house.House;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseConverter {
    private final AddressConverter addressConverter;
    private final UserConverter userConverter;

    public HouseConverter(AddressConverter addressConverter, UserConverter userConverter) {
        this.addressConverter = addressConverter;
        this.userConverter = userConverter;
    }

    public HouseResponseModel houseToResponse(House house){
        HouseResponseModel response = new HouseResponseModel();
        response.setId(house.getId());
        response.setRoomCount(house.getRoomCount());
        response.setMaxPersonCount(house.getMaxPersonCount());
        response.setBuildingType(house.getBuildingType());
        response.setAddress(addressConverter.addressToResponse(house.getAddress()));
        response.setUser(userConverter.toResponse(house.getUser()));
        return response;
    }
    public List<HouseResponseModel> housesToResponses(List<House> houses){
        List<HouseResponseModel> responses = new ArrayList<>();
        for(House house : houses){
            responses.add(houseToResponse(house));
        }
        return responses;
    }
    public House requestToHouse(HouseRequestModel request){
        House house = new House();
        house.setRoomCount(request.getRoomCount());
        house.setMaxPersonCount(request.getMaxPersonCount());
        house.setBuildingType(request.getBuildingType());
        house.setAddress(addressConverter.requestToAddress(request.getAddressRequestModel()));
        return house;
    }
}
