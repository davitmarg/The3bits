package com.example.the3bits.rest.facade.house;

import com.example.the3bits.rest.converter.HouseConverter;
import com.example.the3bits.rest.facade.house.model.HouseRequestModel;
import com.example.the3bits.rest.facade.house.model.HouseResponseModel;
import com.example.the3bits.rest.persistence.house.House;
import com.example.the3bits.rest.service.house.HouseServiceInterface;
import com.example.the3bits.rest.service.rental.RentalServiceInterface;
import com.example.the3bits.rest.service.user.UserServiceInterface;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class HouseFacade {
    private final HouseServiceInterface houseService;
    private final UserServiceInterface userService;
    private final HouseConverter houseConverter;
    private final RentalServiceInterface rentalService;

    public HouseFacade(HouseServiceInterface houseService, UserServiceInterface userService, HouseConverter houseConverter, RentalServiceInterface rentalService) {
        this.houseService = houseService;
        this.userService = userService;
        this.houseConverter = houseConverter;
        this.rentalService = rentalService;
    }

    public List<HouseResponseModel> getAll(){
        List<House> all = houseService.getAll();
        return houseConverter.housesToResponses(all);
    }
    public HouseResponseModel get(Long id){
        House house = houseService.get(id);
        return houseConverter.houseToResponse(house);
    }
    public HouseResponseModel add(HouseRequestModel request){
        House house = houseConverter.requestToHouse(request);
        house.setUser(userService.get(request.getUserId()));

        House add = houseService.add(house);
        return houseConverter.houseToResponse(add);
    }
    public HouseResponseModel update(Long id, HouseRequestModel request){
        House house = houseConverter.requestToHouse(request);
        House update = houseService.update(id, house);
        return houseConverter.houseToResponse(update);
    }
    public List<HouseResponseModel> delete(Long id){
        House house = houseService.get(id);
        rentalService.deleteByHouse(house);
        List<House> all = houseService.delete(id);
        return houseConverter.housesToResponses(all);
    }
}