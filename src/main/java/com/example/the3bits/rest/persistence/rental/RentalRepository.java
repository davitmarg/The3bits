package com.example.the3bits.rest.persistence.rental;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<RentalAnnouncement, Long> {
}
