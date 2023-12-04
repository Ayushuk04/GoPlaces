package com.goPlaces.trip.controller;

import com.goPlaces.trip.dto.ListResponse;
import com.goPlaces.trip.dto.PlaceAccommodationDto;
import com.goPlaces.trip.entities.placeDetails.PlaceAccommodation;
import com.goPlaces.trip.exception.ApiResponse;
import com.goPlaces.trip.exception.ResourceNotFoundException;
import com.goPlaces.trip.service.PlaceAccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accommodation")
public class PlaceAccommodationController {
    @Autowired
    private PlaceAccommodationService placeAccommodationService;


    //Create Place
    @PostMapping("/")
    public ResponseEntity<PlaceAccommodationDto> createPlace(@RequestBody PlaceAccommodationDto placeAccommodationDto) {
        PlaceAccommodationDto createPlaceAccommodation = this.placeAccommodationService.createPlace(placeAccommodationDto);
        return new ResponseEntity<>(createPlaceAccommodation, HttpStatus.CREATED);
    }

    //Update Place

    @PutMapping("/{id}")
    public ResponseEntity<PlaceAccommodationDto> updatePlace(@PathVariable String id,  @RequestBody PlaceAccommodationDto placeAccommodationDto){
        PlaceAccommodationDto getPlace=this.placeAccommodationService.getById(id);
        if(getPlace==null){
            throw new ResourceNotFoundException("Place","Id",id);

        }else{
            getPlace=this.placeAccommodationService.createPlace(placeAccommodationDto);
            return ResponseEntity.ok(getPlace);}

    }
    //Get places by id
    @GetMapping("/{id}")
    public ResponseEntity<PlaceAccommodationDto> getById(@PathVariable String id){
        PlaceAccommodationDto place=this.placeAccommodationService.getById(id);

        return ResponseEntity.ok(place);
    }
    //Delete places by id
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delPlace(@PathVariable String id){
        PlaceAccommodationDto place=this.placeAccommodationService.getById(id);
        if(place==null){
            throw new ResourceNotFoundException("Accommodation","Id",id);
        }
        this.placeAccommodationService.delById(id);
        return  ResponseEntity.ok(new ApiResponse("Accommodation deleted successfully",true));
    }
    //Get all places
    @GetMapping("/")
    public ResponseEntity<ListResponse> getAllPlaces(@RequestParam(value="pageNumber", defaultValue = "0",required = false)int page,
                                                     @RequestParam(value="sortBy", defaultValue = "propertyName",required = false)String sortBy,
                                                     @RequestParam(value = "limit", defaultValue = "7",required = false)int limit,
                                                     @RequestParam(value="sortDir", defaultValue = "asc", required = false)String sortDir)
    {
        return ResponseEntity.ok(this.placeAccommodationService.getAll(page, limit, sortBy, sortDir));


    }
}
