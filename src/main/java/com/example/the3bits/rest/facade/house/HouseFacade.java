package com.example.the3bits.rest.facade.house;

import com.example.the3bits.rest.converter.HouseConverter;
import com.example.the3bits.rest.facade.house.model.HouseRequestModel;
import com.example.the3bits.rest.facade.house.model.HouseResponseModel;
import com.example.the3bits.rest.persistence.house.House;
import com.example.the3bits.rest.service.house.HouseServiceInterface;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HouseFacade {
    private final HouseServiceInterface houseServiceInterface;
    private final HouseConverter houseConverter;

    public HouseFacade(HouseServiceInterface houseServiceInterface, HouseConverter houseConverter) {
        this.houseServiceInterface = houseServiceInterface;
        this.houseConverter = houseConverter;
    }

    public List<HouseResponseModel> getAll(){
        List<House> all = houseServiceInterface.getAll();
        return houseConverter.housesToResponses(all);
    }
    public HouseResponseModel get(Long id){
        House house = houseServiceInterface.get(id);
        return houseConverter.houseToResponse(house);
    }
    public HouseResponseModel add(HouseRequestModel request){
        House house = houseConverter.requestToHouse(request);
        House add = houseServiceInterface.add(house);
        return houseConverter.houseToResponse(add);
    }
    public HouseResponseModel update(Long id, HouseRequestModel request){
        House house = houseConverter.requestToHouse(request);
        House update = houseServiceInterface.update(id, house);
        return houseConverter.houseToResponse(update);
    }
    public List<HouseResponseModel> delete(Long id){
        houseServiceInterface.delete(id);
        List<House> all = houseServiceInterface.getAll();
        return houseConverter.housesToResponses(all);
    }
}
