package com.example.the3bits.rest.controller;

import com.example.the3bits.rest.facade.house.HouseFacade;
import com.example.the3bits.rest.facade.house.model.HouseRequestModel;
import com.example.the3bits.rest.facade.house.model.HouseResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HouseController {
    private final HouseFacade houseFacade;

    public HouseController(HouseFacade houseFacade) {
        this.houseFacade = houseFacade;
    }

    @GetMapping(value = "/house")
    public ResponseEntity<List<HouseResponseModel>> getAll(){
        return ResponseEntity.ok(houseFacade.getAll());
    }
    @GetMapping(value = "/house/{id}")
    public ResponseEntity<HouseResponseModel> get(@PathVariable Long id){
        return ResponseEntity.ok(houseFacade.get(id));
    }
    @PostMapping(value = "/house")
    public ResponseEntity<HouseResponseModel> add(@RequestBody HouseRequestModel request){
        return ResponseEntity.ok(houseFacade.add(request));
    }
    @PutMapping(value = "/house/{id}")
    public ResponseEntity<HouseResponseModel> update(@PathVariable Long id, @RequestBody HouseRequestModel request){
        return ResponseEntity.ok(houseFacade.update(id,request));
    }
    @DeleteMapping(value = "/house/{id}")
    public ResponseEntity<List<HouseResponseModel>> delete(@PathVariable Long id){
        return ResponseEntity.ok(houseFacade.delete(id));
    }
}
