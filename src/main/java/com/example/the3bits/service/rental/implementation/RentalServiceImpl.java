package com.example.the3bits.service.rental.implementation;

import com.example.the3bits.converter.RentalConverter;
import com.example.the3bits.persistence.house.House;
import com.example.the3bits.persistence.rental.RentalAnnouncement;
import com.example.the3bits.persistence.rental.RentalRepository;
import com.example.the3bits.persistence.user.User;
import com.example.the3bits.service.rental.RentalServiceInterface;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
    public RentalAnnouncement add(RentalAnnouncement rentalAnnouncement) {
        return rentalRepository.save(rentalAnnouncement);
    }

    @Override
    @Transactional
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
    @Transactional
    public List<RentalAnnouncement> delete(Long id) {
        rentalRepository.deleteById(id);
        return rentalRepository.findAll();
    }

    @Override
    public List<RentalAnnouncement> getByUser(User user) {
        return rentalRepository.findAllByUser(user);
    }

    @Override
    public List<RentalAnnouncement> getByHouse(House house) {
        return rentalRepository.findAllByHouse(house);
    }

    @Override
    @Transactional
    public List<RentalAnnouncement> deleteByUser(User user) {
        rentalRepository.deleteAllByUser(user);
        return  rentalRepository.findAll();
    }

    @Override
    @Transactional
    public List<RentalAnnouncement> deleteByHouse(House house) {
        rentalRepository.deleteAllByHouse(house);
        return  rentalRepository.findAll();
    }

}
