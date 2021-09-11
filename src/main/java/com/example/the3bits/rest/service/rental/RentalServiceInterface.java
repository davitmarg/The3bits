package com.example.the3bits.rest.service.rental;

import com.example.the3bits.rest.persistence.house.House;
import com.example.the3bits.rest.persistence.rental.RentalAnnouncement;

import java.util.List;

public interface RentalServiceInterface {
    RentalAnnouncement get(Long id);
    List<RentalAnnouncement> getAll();
    RentalAnnouncement add(RentalAnnouncement rentalAnnouncement);
    RentalAnnouncement update(Long id, RentalAnnouncement rentalAnnouncement);
    List<RentalAnnouncement> delete(Long id);
    void deleteByHouse(House house);
}
