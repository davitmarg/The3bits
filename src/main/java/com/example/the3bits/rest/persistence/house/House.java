package com.example.the3bits.rest.persistence.house;

import javax.persistence.*;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int roomCount;
    private int maxPersonCount;
    private BuildingType buildingType;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Long getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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
