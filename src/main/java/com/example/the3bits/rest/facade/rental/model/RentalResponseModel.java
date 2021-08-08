package com.example.the3bits.rest.facade.rental.model;

import com.example.the3bits.rest.facade.house.model.HouseResponseModel;
import com.example.the3bits.rest.facade.user.model.UserResponseModel;

public class RentalResponseModel {
    private Long id;
    private HouseResponseModel houseResponseModel;
    private int price;
    private String description;
    private UserResponseModel hostResponseModel;
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HouseResponseModel getHouseResponseModel() {
        return houseResponseModel;
    }

    public void setHouseResponseModel(HouseResponseModel houseResponseModel) {
        this.houseResponseModel = houseResponseModel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserResponseModel getHostResponseModel() {
        return hostResponseModel;
    }

    public void setHostResponseModel(UserResponseModel hostResponseModel) {
        this.hostResponseModel = hostResponseModel;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
