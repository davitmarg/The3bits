package com.example.the3bits.rest.facade.rental;

import com.example.the3bits.rest.converter.RentalConverter;
import com.example.the3bits.rest.facade.rental.model.RentalRequestModel;
import com.example.the3bits.rest.facade.rental.model.RentalResponseModel;
import com.example.the3bits.rest.persistence.house.House;
import com.example.the3bits.rest.persistence.rental.RentalAnnouncement;
import com.example.the3bits.rest.persistence.user.User;
import com.example.the3bits.rest.service.house.HouseServiceInterface;
import com.example.the3bits.rest.service.rental.RentalServiceInterface;
import com.example.the3bits.rest.service.user.UserServiceInterface;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RentalFacade {
    private final RentalServiceInterface rentalServiceInterface;
    private final UserServiceInterface userServiceInterface;
    private final HouseServiceInterface houseServiceInterface;
    private final RentalConverter rentalConverter;

    public RentalFacade(RentalServiceInterface rentalServiceInterface, UserServiceInterface userServiceInterface, HouseServiceInterface houseServiceInterface, RentalConverter rentalConverter) {
        this.rentalServiceInterface = rentalServiceInterface;
        this.userServiceInterface = userServiceInterface;
        this.houseServiceInterface = houseServiceInterface;
        this.rentalConverter = rentalConverter;
    }

    public RentalResponseModel get(Long id){
        RentalAnnouncement rentalAnnouncement = rentalServiceInterface.get(id);
        return rentalConverter.announcementToResponse(rentalAnnouncement);
    }
    public List<RentalResponseModel> getAll(){
        List<RentalAnnouncement> all = rentalServiceInterface.getAll();
        return rentalConverter.announcementsToResponses(all);
    }
    public RentalResponseModel add(RentalRequestModel request){
        House house = houseServiceInterface.get(request.getHouseId());
        User host = userServiceInterface.get(request.getHostId());
        RentalAnnouncement rentalAnnouncement = rentalConverter.requestToAnnouncement(request, house, host);
        RentalAnnouncement add = rentalServiceInterface.add(rentalAnnouncement);
        return rentalConverter.announcementToResponse(add);
    }
    public RentalResponseModel update(Long id, RentalRequestModel request){
        House house = houseServiceInterface.get(request.getHouseId());
        User host = userServiceInterface.get(request.getHostId());
        RentalAnnouncement rentalAnnouncement = rentalConverter.requestToAnnouncement(request, house, host);
        RentalAnnouncement update = rentalServiceInterface.update(id, rentalAnnouncement);
        return rentalConverter.announcementToResponse(update);
    }
    public List<RentalResponseModel> delete(Long id){
        List<RentalAnnouncement> delete = rentalServiceInterface.delete(id);
        return rentalConverter.announcementsToResponses(delete);
    }
}
