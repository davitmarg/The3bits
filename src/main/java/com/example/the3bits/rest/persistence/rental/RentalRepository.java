package com.example.the3bits.rest.persistence.rental;

import com.example.the3bits.rest.persistence.house.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<RentalAnnouncement, Long> {
    void deleteByHouse(House house);
}
