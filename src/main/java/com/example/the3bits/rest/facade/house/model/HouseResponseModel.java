package com.example.the3bits.rest.facade.house.model;

import com.example.the3bits.rest.persistence.house.BuildingType;

public class HouseResponseModel {
    private Long id;
    private int roomCount;
    private int maxPersonCount;
    private BuildingType buildingType;
    private AddressResponseModel addressResponseModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressResponseModel getAddressResponseModel() {
        return addressResponseModel;
    }

    public void setAddressResponseModel(AddressResponseModel addressResponseModel) {
        this.addressResponseModel = addressResponseModel;
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
