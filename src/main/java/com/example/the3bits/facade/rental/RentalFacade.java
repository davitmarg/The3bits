package com.example.the3bits.facade.rental;

import com.example.the3bits.converter.RentalConverter;
import com.example.the3bits.facade.rental.model.RentalRequestModel;
import com.example.the3bits.facade.rental.model.RentalResponseModel;
import com.example.the3bits.persistence.house.House;
import com.example.the3bits.persistence.rental.RentalAnnouncement;
import com.example.the3bits.persistence.user.User;
import com.example.the3bits.service.house.HouseServiceInterface;
import com.example.the3bits.service.rental.RentalServiceInterface;
import com.example.the3bits.service.user.UserServiceInterface;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RentalFacade {
    private final RentalServiceInterface rentalService;
    private final UserServiceInterface userService;
    private final HouseServiceInterface houseService;
    private final RentalConverter rentalConverter;

    public RentalFacade(RentalServiceInterface rentalService, UserServiceInterface userService, HouseServiceInterface houseService, RentalConverter rentalConverter) {
        this.rentalService = rentalService;
        this.userService = userService;
        this.houseService = houseService;
        this.rentalConverter = rentalConverter;
    }

    public RentalResponseModel get(Long id){
        RentalAnnouncement rentalAnnouncement = rentalService.get(id);
        return rentalConverter.announcementToResponse(rentalAnnouncement);
    }
    public List<RentalResponseModel> getAll(){
        List<RentalAnnouncement> all = rentalService.getAll();
        return rentalConverter.announcementsToResponses(all);
    }
    public RentalResponseModel add(RentalRequestModel request){
        House house = houseService.get(request.getHouseId());
        User host = userService.get(request.getUserId());
        RentalAnnouncement rentalAnnouncement = rentalConverter.requestToAnnouncement(request, house, host);
        RentalAnnouncement add = rentalService.add(rentalAnnouncement);
        return rentalConverter.announcementToResponse(add);
    }
    public RentalResponseModel update(Long id, RentalRequestModel request){
        House house = houseService.get(request.getHouseId());
        User host = userService.get(request.getUserId());
        RentalAnnouncement rentalAnnouncement = rentalConverter.requestToAnnouncement(request, house, host);
        RentalAnnouncement update = rentalService.update(id, rentalAnnouncement);
        return rentalConverter.announcementToResponse(update);
    }
    public List<RentalResponseModel> delete(Long id){
        List<RentalAnnouncement> delete = rentalService.delete(id);
        return rentalConverter.announcementsToResponses(delete);
    }
}
