package com.example.the3bits.rest.facade.house.model;

import com.example.the3bits.rest.facade.user.model.UserResponseModel;
import com.example.the3bits.rest.persistence.house.BuildingType;

public class HouseResponseModel {
    private Long id;
    private UserResponseModel user;
    private int roomCount;
    private int maxPersonCount;
    private BuildingType buildingType;
    private AddressResponseModel address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserResponseModel getUser() {
        return user;
    }

    public void setUser(UserResponseModel user) {
        this.user = user;
    }

    public AddressResponseModel getAddress() {
        return address;
    }

    public void setAddress(AddressResponseModel address) {
        this.address = address;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getMaxPersonCount() {
        return maxPersonCount;
    }

    public void setMaxPersonCount(int maxPersonCount) {
        this.maxPersonCount = maxPersonCount;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }
}
