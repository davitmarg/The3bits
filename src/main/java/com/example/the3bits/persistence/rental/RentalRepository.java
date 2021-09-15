package com.example.the3bits.persistence.rental;

import com.example.the3bits.persistence.house.House;
import com.example.the3bits.persistence.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<RentalAnnouncement, Long> {
    List<RentalAnnouncement> findAllByUser(User user);
    List<RentalAnnouncement> findAllByHouse(House house);
    void deleteAllByUser(User user);
    void deleteAllByHouse(House house);
}
