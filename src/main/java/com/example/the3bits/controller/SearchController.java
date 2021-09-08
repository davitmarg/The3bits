package com.example.the3bits.controller;

import com.example.the3bits.facade.rental.model.RentalResponseModel;
import com.example.the3bits.facade.search.SearchFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    private final SearchFacade searchFacade;

    public SearchController(SearchFacade searchFacade) {
        this.searchFacade = searchFacade;
    }

    @GetMapping("/search/{term}")
    public ResponseEntity<List<RentalResponseModel>> search(@PathVariable String term){
        return ResponseEntity.ok(searchFacade.search(term));
    }
}