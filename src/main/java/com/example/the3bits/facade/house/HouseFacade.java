package com.example.the3bits.facade.house;

import com.example.the3bits.converter.HouseConverter;
import com.example.the3bits.facade.house.model.HouseRequestModel;
import com.example.the3bits.facade.house.model.HouseResponseModel;
import com.example.the3bits.persistence.house.House;
import com.example.the3bits.persistence.rental.RentalAnnouncement;
import com.example.the3bits.persistence.user.User;
import com.example.the3bits.service.house.HouseServiceInterface;
import com.example.the3bits.service.rental.RentalServiceInterface;
import com.example.the3bits.service.user.UserServiceInterface;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HouseFacade {
    private final HouseServiceInterface houseService;
    private final UserServiceInterface userService;
    private final RentalServiceInterface rentalService;
    private final HouseConverter houseConverter;

    public HouseFacade(HouseServiceInterface houseService, UserServiceInterface userService, RentalServiceInterface rentalService, HouseConverter houseConverter) {
        this.houseService = houseService;
        this.userService = userService;
        this.rentalService = rentalService;
        this.houseConverter = houseConverter;
    }

    public List<HouseResponseModel> getAll() {
        List<House> all = houseService.getAll();
        return houseConverter.housesToResponses(all);
    }

    public HouseResponseModel get(Long id) {
        House house = houseService.get(id);
        return houseConverter.houseToResponse(house);
    }

    public HouseResponseModel add(HouseRequestModel request) {
        House house = houseConverter.requestToHouse(request);
        house.setUser(userService.get(request.getUserId()));

        House add = houseService.add(house);
        return houseConverter.houseToResponse(add);
    }

    public HouseResponseModel update(Long id, HouseRequestModel request) {
        House house = houseConverter.requestToHouse(request);
        House update = houseService.update(id, house);
        return houseConverter.houseToResponse(update);
    }

    public List<HouseResponseModel> delete(Long id) {
        House house = houseService.get(id);
        rentalService.deleteByHouse(house);
        houseService.delete(id);
        List<House> all = houseService.getAll();
        return houseConverter.housesToResponses(all);
    }

    public List<HouseResponseModel> getByUser(Long userId) {
        User user = userService.get(userId);
        List<House> byUser = houseService.getByUser(user);
        return houseConverter.housesToResponses(byUser);
    }
}
