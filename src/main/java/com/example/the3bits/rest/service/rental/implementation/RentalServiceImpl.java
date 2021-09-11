package com.example.the3bits.rest.service.rental.implementation;

import com.example.the3bits.rest.persistence.house.House;
import com.example.the3bits.rest.persistence.rental.RentalAnnouncement;
import com.example.the3bits.rest.persistence.rental.RentalRepository;
import com.example.the3bits.rest.service.rental.RentalServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalServiceImpl implements RentalServiceInterface {
    private final RentalRepository rentalRepository;

    public RentalServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public RentalAnnouncement get(Long id) {
        return rentalRepository.getById(id);
    }

    @Override
    public List<RentalAnnouncement> getAll() {
        return rentalRepository.findAll();
    }

    @Override
    public RentalAnnouncement add(RentalAnnouncement rentalAnnouncement) {
        return rentalRepository.save(rentalAnnouncement);
    }

    @Override
    public RentalAnnouncement update(Long id, RentalAnnouncement rentalAnnouncement) {
        RentalAnnouncement byId = rentalRepository.getById(id);
        byId.setHouse(rentalAnnouncement.getHouse());
        byId.setPrice(rentalAnnouncement.getPrice());
        byId.setDescription(rentalAnnouncement.getDescription());
        byId.setUser(rentalAnnouncement.getUser());
        byId.setActive(rentalAnnouncement.isActive());
        return rentalRepository.save(byId);
    }

    @Override
    public List<RentalAnnouncement> delete(Long id) {
        rentalRepository.deleteById(id);
        return rentalRepository.findAll();
    }

    @Override
    public void deleteByHouse(House house) {
        rentalRepository.deleteByHouse(house);
    }
}
