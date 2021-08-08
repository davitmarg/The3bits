package com.example.the3bits.rest.persistence.rental;

import com.example.the3bits.rest.persistence.house.House;
import com.example.the3bits.rest.persistence.user.User;

import javax.persistence.*;

@Entity
public class RentalAnnouncement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private House house;
    private int price;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private User host;
    private boolean active;

    public Long getId() {
        return id;
    }


    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
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

    public User getHost() {
        return host;
    }

    public void setHost(User host) {
        this.host = host;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
