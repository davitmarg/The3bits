package com.example.the3bits.service.rental;

import com.example.the3bits.persistence.house.House;
import com.example.the3bits.persistence.rental.RentalAnnouncement;
import com.example.the3bits.persistence.user.User;

import java.util.List;

public interface RentalServiceInterface {
    RentalAnnouncement get(Long id);
    List<RentalAnnouncement> getAll();
    RentalAnnouncement add(RentalAnnouncement rentalAnnouncement);
    RentalAnnouncement update(Long id, RentalAnnouncement rentalAnnouncement);
    List<RentalAnnouncement> delete(Long id);
    List<RentalAnnouncement> getByUser(User user);
    List<RentalAnnouncement> getByHouse(House house);

    List<RentalAnnouncement> deleteByUser(User user);
    List<RentalAnnouncement> deleteByHouse(House house);
}
