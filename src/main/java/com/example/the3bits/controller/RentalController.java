package com.example.the3bits.controller;

import com.example.the3bits.facade.rental.RentalFacade;
import com.example.the3bits.facade.rental.model.RentalRequestModel;
import com.example.the3bits.facade.rental.model.RentalResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentalController {
    private final RentalFacade rentalFacade;

    public RentalController(RentalFacade rentalFacade) {
        this.rentalFacade = rentalFacade;
    }
    @GetMapping(value = "/announcement/{id}")
    public ResponseEntity<RentalResponseModel> get(@PathVariable Long id){
        return ResponseEntity.ok(rentalFacade.get(id));
    }
    @GetMapping(value = "/announcement")
    public ResponseEntity<List<RentalResponseModel>> getAll(){
        return ResponseEntity.ok(rentalFacade.getAll());
    }
    @PostMapping(value = "/announcement")
    public ResponseEntity<RentalResponseModel> add(@RequestBody RentalRequestModel request){
        return ResponseEntity.ok(rentalFacade.add(request));
    }
    @PutMapping(value = "/announcement/{id}")
    public ResponseEntity<RentalResponseModel> update(@PathVariable Long id, @RequestBody RentalRequestModel request){
        return ResponseEntity.ok(rentalFacade.update(id,request));
    }
    @DeleteMapping(value = "/announcement/{id}")
    public ResponseEntity<List<RentalResponseModel>> delete(@PathVariable Long id){
        return ResponseEntity.ok(rentalFacade.delete(id));
    }
}
