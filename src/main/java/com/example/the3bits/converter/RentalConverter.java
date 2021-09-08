package com.example.the3bits.converter;

import com.example.the3bits.facade.rental.model.RentalRequestModel;
import com.example.the3bits.facade.rental.model.RentalResponseModel;
import com.example.the3bits.persistence.house.House;
import com.example.the3bits.persistence.rental.RentalAnnouncement;
import com.example.the3bits.persistence.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalConverter {
    private final HouseConverter houseConverter;
    private final UserConverter userConverter;

    public RentalConverter(HouseConverter houseConverter, UserConverter userConverter) {
        this.houseConverter = houseConverter;
        this.userConverter = userConverter;
    }

    public RentalAnnouncement requestToAnnouncement(RentalRequestModel request, House house, User host){
        RentalAnnouncement rentalAnnouncement = new RentalAnnouncement();
        rentalAnnouncement.setHouse(house);
        rentalAnnouncement.setPrice(request.getPrice());
        rentalAnnouncement.setDescription(request.getDescription());
        rentalAnnouncement.setUser(host);
        return rentalAnnouncement;
    }
    public RentalResponseModel announcementToResponse(RentalAnnouncement rentalAnnouncement){
        RentalResponseModel response = new RentalResponseModel();
        response.setId(rentalAnnouncement.getId());
        response.setHouseResponseModel(houseConverter.houseToResponse(rentalAnnouncement.getHouse()));
        response.setPrice(rentalAnnouncement.getPrice());
        response.setDescription(rentalAnnouncement.getDescription());
        response.setUser(userConverter.toResponse(rentalAnnouncement.getUser()));
        response.setActive(rentalAnnouncement.isActive());
        return response;
    }
    public List<RentalResponseModel> announcementsToResponses(List<RentalAnnouncement> rentalAnnouncements){
        List<RentalResponseModel> responses = new ArrayList<>();
        for (RentalAnnouncement announcement:rentalAnnouncements){
            responses.add(announcementToResponse(announcement));
        }
        return responses;
    }
}
