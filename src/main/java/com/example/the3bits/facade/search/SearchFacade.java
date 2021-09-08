package com.example.the3bits.facade.search;

import com.example.the3bits.converter.RentalConverter;
import com.example.the3bits.facade.rental.model.RentalResponseModel;
import com.example.the3bits.service.rental.RentalServiceInterface;
import com.example.the3bits.service.search.CustomSearchEngine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFacade {

    private final CustomSearchEngine searchEngine;
    private final RentalServiceInterface rentalService;
    private final RentalConverter rentalConverter;


    public SearchFacade(CustomSearchEngine searchEngine, RentalServiceInterface rentalService, RentalConverter rentalConverter) {
        this.searchEngine = searchEngine;
        this.rentalService = rentalService;
        this.rentalConverter = rentalConverter;
    }

    public List<RentalResponseModel> search(String term) {
        List<RentalResponseModel> rentalResponseModels = rentalConverter.announcementsToResponses(rentalService.getAll());
        return searchEngine.search(term,rentalResponseModels);
    }

}
