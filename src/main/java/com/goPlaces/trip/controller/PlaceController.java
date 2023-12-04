package com.goPlaces.trip.controller;

import com.goPlaces.trip.dto.ListResponse;
import com.goPlaces.trip.dto.PlaceDto;
import com.goPlaces.trip.dto.TripDto;
import com.goPlaces.trip.exception.ApiResponse;
import com.goPlaces.trip.exception.ResourceNotFoundException;
import com.goPlaces.trip.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    //Create Place
    @PostMapping("/")
    public ResponseEntity<PlaceDto> createPlace(@RequestBody PlaceDto placeDto) {
        PlaceDto createPlaceDto = this.placeService.createPlace(placeDto);
        return new ResponseEntity<>(createPlaceDto, HttpStatus.CREATED);
    }

    //Update Place

    @PutMapping("/{id}")
    public ResponseEntity<PlaceDto> updatePlace(@PathVariable String id,  @RequestBody PlaceDto placeDto){
        PlaceDto getPlace=this.placeService.getById(id);
        if(getPlace==null){
            throw new ResourceNotFoundException("Place","Id",id);

        }else{
            getPlace=this.placeService.createPlace(placeDto);
            return ResponseEntity.ok(getPlace);}

    }
    //Get places by id
    @GetMapping("/{id}")
    public ResponseEntity<PlaceDto> getById(@PathVariable String id){
        PlaceDto place=this.placeService.getById(id);

        return ResponseEntity.ok(place);
    }
    //Delete places by id
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delPlace(@PathVariable String id){
        PlaceDto place=this.placeService.getById(id);
        if(place==null){
            throw new ResourceNotFoundException("Place","Id",id);
        }
        this.placeService.delById(id);
        return  ResponseEntity.ok(new ApiResponse("Place deleted successfully",true));
    }
    //Get all places
    @GetMapping("/")
    public ResponseEntity<ListResponse> getAllPlaces(@RequestParam(value="pageNumber", defaultValue = "0",required = false)int page,
                                                    @RequestParam(value="sortBy", defaultValue = "placeName",required = false)String sortBy,
                                                    @RequestParam(value = "limit", defaultValue = "7",required = false)int limit,
                                                    @RequestParam(value="sortDir", defaultValue = "asc", required = false)String sortDir)
    {
        return ResponseEntity.ok(this.placeService.getAll(page, limit, sortBy, sortDir));


    }

    //Assign accommodation to place
    @PutMapping("/{placeId}/accommodation/{accommodationId}")
    public ResponseEntity<PlaceDto> assignAccommodationToPlace(
            @PathVariable String placeId,
            @PathVariable String accommodationId
    ){
        PlaceDto place=placeService.assignAccommodationToPlace(placeId, accommodationId);
        return ResponseEntity.ok(place);
    }
    //Delete accommodation from Place
    @DeleteMapping("/{placeId}/accommodation/{accommodationId}")
    public ResponseEntity<ApiResponse> delPlaceFromTrip(@PathVariable String placeId,@PathVariable String accommodationId){
        this.placeService.delAccommodationFromPlace(placeId,accommodationId);

        return  ResponseEntity.ok(new ApiResponse("Accommodation deleted successfully",true));
    }
    //Get all places in a trip

//    @GetMapping("/trip/{tripId}/places")
//    public ResponseEntity<List<PlaceDto>> getAllPlacesByTrip(@PathVariable String tripId){
//        List<PlaceDto> allPlaces=this.placeService.getPlacesByTrip(tripId);
//        return new ResponseEntity<List<PlaceDto>>(allPlaces,HttpStatus.OK);
//    }
    //Search places
//    @GetMapping("/search/{keyword}")
//    public ResponseEntity<List<PlaceDto>> searchPlace(@PathVariable String keyword){
//        List<PlaceDto> place=this.placeService.search(keyword);
//        return new ResponseEntity<List<PlaceDto>>(place,HttpStatus.OK);
//
//    }
}
