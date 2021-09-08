package com.example.the3bits.facade.house.model;

import com.example.the3bits.persistence.house.BuildingType;

public class HouseRequestModel {

    private Long userId;
    private int roomCount;
    private int maxPersonCount;
    private BuildingType buildingType;
    private AddressRequestModel addressRequestModel;

    public AddressRequestModel getAddressRequestModel() {
        return addressRequestModel;
    }

    public void setAddressRequestModel(AddressRequestModel addressRequestModel) {
        this.addressRequestModel = addressRequestModel;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
