package com.example.the3bits.rest.persistence.house;

import com.example.the3bits.rest.persistence.rental.RentalAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House,Long> {
}
