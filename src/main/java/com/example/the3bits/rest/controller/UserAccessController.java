package com.example.the3bits.rest.controller;

import com.example.the3bits.rest.facade.house.HouseFacade;
import com.example.the3bits.rest.facade.house.model.HouseRequestModel;
import com.example.the3bits.rest.facade.house.model.HouseResponseModel;
import com.example.the3bits.rest.facade.rental.RentalFacade;
import com.example.the3bits.rest.facade.rental.model.RentalRequestModel;
import com.example.the3bits.rest.facade.rental.model.RentalResponseModel;
import com.example.the3bits.rest.facade.user.UserFacade;
import com.example.the3bits.rest.facade.user.model.UserResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class UserAccessController {

    private final HouseFacade houseFacade;
    private final RentalFacade rentalFacade;
    private final UserFacade userFacade;

    public UserAccessController(HouseFacade houseFacade, RentalFacade rentalFacade, UserFacade userFacade) {
        this.houseFacade = houseFacade;
        this.rentalFacade = rentalFacade;
        this.userFacade = userFacade;
    }

    @PostMapping("/addHouse")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<HouseResponseModel> login(Authentication authentication, @RequestBody HouseRequestModel request) {
        Long userId = userFacade.getIdByAuthentication(authentication);
        request.setUserId(userId);
        return ResponseEntity.ok(houseFacade.add(request));
    }

    @PostMapping("/addAnnouncement")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<RentalResponseModel> login(Authentication authentication, @RequestBody RentalRequestModel request) {
        Long userId = userFacade.getIdByAuthentication(authentication);
        request.setUserId(userId);
        return ResponseEntity.ok(rentalFacade.add(request));
    }
}
