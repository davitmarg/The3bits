package com.example.the3bits.converter;

import com.example.the3bits.facade.house.model.AddressRequestModel;
import com.example.the3bits.facade.house.model.AddressResponseModel;
import com.example.the3bits.persistence.house.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressConverter {
    public Address requestToAddress(AddressRequestModel request){
        Address address = new Address();
        address.setCountry(request.getCountry());
        address.setCity(request.getCity());
        address.setStreet(request.getStreet());
        address.setHouseNumber(request.getHouseNumber());
        address.setPostCode(request.getPostCode());
        return address;
    }
    public AddressResponseModel addressToResponse(Address address){
        AddressResponseModel response = new AddressResponseModel();
        response.setId(address.getId());
        response.setCountry(address.getCountry());
        response.setCity(address.getCity());
        response.setStreet(address.getStreet());
        response.setHouseNumber(address.getHouseNumber());
        response.setPostCode(address.getPostCode());
        return response;
    }
}
