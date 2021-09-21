package com.example.the3bits.controller;

import com.example.the3bits.facade.house.HouseFacade;
import com.example.the3bits.facade.house.model.HouseRequestModel;
import com.example.the3bits.facade.house.model.HouseResponseModel;
import com.example.the3bits.facade.rental.RentalFacade;
import com.example.the3bits.facade.rental.model.RentalRequestModel;
import com.example.the3bits.facade.rental.model.RentalResponseModel;
import com.example.the3bits.facade.user.UserFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public ResponseEntity<HouseResponseModel> addHouse(Authentication authentication, @RequestBody HouseRequestModel request) {
        Long userId = userFacade.getIdByAuthentication(authentication);
        request.setUserId(userId);
        return ResponseEntity.ok(houseFacade.add(request));
    }

    @PutMapping("/updateHouse")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<HouseResponseModel> updateHouse(@PathVariable Long id, Authentication authentication, @RequestBody HouseRequestModel request) {
        Long userId = userFacade.getIdByAuthentication(authentication);
        if(!(houseFacade.get(id)!= null && houseFacade.get(id).getUser().getId().equals(userId)))
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        return ResponseEntity.ok(houseFacade.update(id,request));
    }

    @DeleteMapping("/deleteHouse")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<List<HouseResponseModel>> deleteHouse(Authentication authentication,@PathVariable Long id ) {
        Long userId = userFacade.getIdByAuthentication(authentication);
        if(!(houseFacade.get(id)!= null && houseFacade.get(id).getUser().getId().equals(userId)))
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        return ResponseEntity.ok(houseFacade.delete(id));
    }


    @GetMapping("/getHouses")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<List<HouseResponseModel>> getHouses(Authentication authentication) {
        Long userId = userFacade.getIdByAuthentication(authentication);
        return ResponseEntity.ok(houseFacade.getByUser(userId));
    }

    @PostMapping("/addAnnouncement")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<RentalResponseModel> addAnnouncement(Authentication authentication, @RequestBody RentalRequestModel request) {
        Long userId = userFacade.getIdByAuthentication(authentication);
        request.setUserId(userId);
        if(!(houseFacade.get(request.getHouseId())!=null && houseFacade.get(request.getHouseId()).getUser().getId().equals(userId))) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        return ResponseEntity.ok(rentalFacade.add(request));
    }
    @PutMapping("/updateAnnouncement")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<RentalResponseModel> updateAnnouncement(@PathVariable Long id, Authentication authentication, @RequestBody RentalRequestModel request) {
        Long userId = userFacade.getIdByAuthentication(authentication);
        request.setUserId(userId);


        if(!(rentalFacade.get(id)!=null && rentalFacade.get(id).getUser().getId().equals(userId))) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        if(!(houseFacade.get(request.getHouseId())!=null && houseFacade.get(request.getHouseId()).getUser().getId().equals(userId))) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        return ResponseEntity.ok(rentalFacade.update(id, request));
    }

    @DeleteMapping("/deleteAnnouncement")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<List<RentalResponseModel>> deleteAnnouncement(@PathVariable Long id, Authentication authentication) {
        Long userId = userFacade.getIdByAuthentication(authentication);


        if(!(rentalFacade.get(id)!=null && rentalFacade.get(id).getUser().getId().equals(userId))) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        return ResponseEntity.ok(rentalFacade.delete(id));
    }

    @GetMapping("/getAnnouncements")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<List<RentalResponseModel>> getAnnouncements(Authentication authentication) {
        Long userId = userFacade.getIdByAuthentication(authentication);
        return ResponseEntity.ok(rentalFacade.getByUser(userId));
    }



}
