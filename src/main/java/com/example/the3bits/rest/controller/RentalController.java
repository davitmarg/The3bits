package com.example.the3bits.rest.controller;

import com.example.the3bits.rest.facade.rental.RentalFacade;
import com.example.the3bits.rest.facade.rental.model.RentalRequestModel;
import com.example.the3bits.rest.facade.rental.model.RentalResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentalController {
    private final RentalFacade rentalFacade;

    public RentalController(RentalFacade rentalFacade) {
        this.rentalFacade = rentalFacade;
    }
    @GetMapping(value = "/rent/{id}")
    public ResponseEntity<RentalResponseModel> get(@PathVariable Long id){
        return ResponseEntity.ok(rentalFacade.get(id));
    }
    @GetMapping(value = "/rent")
    public ResponseEntity<List<RentalResponseModel>> getAll(){
        return ResponseEntity.ok(rentalFacade.getAll());
    }
    @PostMapping(value = "/rent")
    public ResponseEntity<RentalResponseModel> add(@RequestBody RentalRequestModel request){
        return ResponseEntity.ok(rentalFacade.add(request));
    }
    @PutMapping(value = "/rent/{id}")
    public ResponseEntity<RentalResponseModel> update(@PathVariable Long id, @RequestBody RentalRequestModel request){
        return ResponseEntity.ok(rentalFacade.update(id,request));
    }
    @DeleteMapping(value = "/rent/{id}")
    public ResponseEntity<List<RentalResponseModel>> delete(@PathVariable Long id){
        return ResponseEntity.ok(rentalFacade.delete(id));
    }
}
