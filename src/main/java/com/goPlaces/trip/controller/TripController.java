package com.goPlaces.trip.controller;

import com.goPlaces.trip.dto.ListResponse;
import com.goPlaces.trip.dto.TripDto;
import com.goPlaces.trip.dto.UserDto;
import com.goPlaces.trip.exception.ApiResponse;
import com.goPlaces.trip.exception.ResourceNotFoundException;
import com.goPlaces.trip.service.TripService;
import com.goPlaces.trip.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/trips")
public class TripController {
    @Autowired
    private TripService tripService;

    @Autowired
    private UserService userService;

    //Create Trip
    @PostMapping("/")
    public ResponseEntity<TripDto> createTrip( @RequestBody TripDto tripDto) {
        TripDto createTripDto = this.tripService.createTrip(tripDto);
        return new ResponseEntity<>(createTripDto, HttpStatus.CREATED);
    }

    //Update Trip

    @PutMapping("/{id}")
    public ResponseEntity<TripDto> updateTrip(@PathVariable String id,  @RequestBody TripDto tripDto){
        TripDto getTrip=this.tripService.getById(id);
        if(getTrip==null){
            throw new ResourceNotFoundException("Trip","Id",id);

        }else{
            getTrip=this.tripService.createTrip(tripDto);
            return ResponseEntity.ok(getTrip);}

    }
    //Get trips by id
    @GetMapping("/{id}")
    public ResponseEntity<TripDto> getById(@PathVariable String id){
        TripDto trip=this.tripService.getById(id);

        return ResponseEntity.ok(trip);
    }
    //Delete trips by id
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delTrip(@PathVariable String id){
        TripDto trip=this.tripService.getById(id);
        if(trip==null){
            throw new ResourceNotFoundException("Trip","Id",id);
        }
        this.tripService.delById(id);
        return  ResponseEntity.ok(new ApiResponse("Trip deleted successfully",true));
    }
    //Get all trips
    @GetMapping("/")
    public ResponseEntity<ListResponse> getAllTrips(@RequestParam(value="pageNumber", defaultValue = "0",required = false)int page,
                                                    @RequestParam(value="sortBy", defaultValue = "name",required = false)String sortBy,
                                                    @RequestParam(value = "limit", defaultValue = "7",required = false)int limit,
                                                    @RequestParam(value="sortDir", defaultValue = "asc", required = false)String sortDir)
    {
        return ResponseEntity.ok(this.tripService.getAll(page, limit, sortBy, sortDir));


    }
    //Search trips
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<TripDto>> searchTrip(@PathVariable String keyword){
        List<TripDto> trip=this.tripService.search(keyword);
        return new ResponseEntity<List<TripDto>>(trip,HttpStatus.OK);

    }
    //  Assign user to Trip
    @PutMapping("/{tripId}/user/{userId}")
    public ResponseEntity<TripDto> assignUserToTrip(
            @PathVariable String tripId,
            @PathVariable String userId
    ){
       TripDto trip=tripService.assignUserToTrip(tripId, userId);
       return ResponseEntity.ok(trip);
    }
    //  Assign place to Trip
    @PutMapping("/{tripId}/place/{placeId}")
    public ResponseEntity<TripDto> assignPlaceToTrip(
            @PathVariable String tripId,
            @PathVariable String placeId
    ){
        TripDto trip=tripService.assignPlaceToTrip(tripId, placeId);
        return ResponseEntity.ok(trip);
    }

    // Remove user from trip
    @DeleteMapping("/{tripId}/user/{userId}")
    public ResponseEntity<ApiResponse> delUserFromTrip(@PathVariable String tripId,@PathVariable String userId){
        this.tripService.delUserFromTrip(tripId,userId);

        return  ResponseEntity.ok(new ApiResponse("User deleted successfully",true));
    }

    // Remove place from trip
    @DeleteMapping("/{tripId}/place/{placeId}")
    public ResponseEntity<ApiResponse> delPlaceFromTrip(@PathVariable String tripId,@PathVariable String placeId){
        this.tripService.delPlaceFromTrip(tripId,placeId);

        return  ResponseEntity.ok(new ApiResponse("User deleted successfully",true));
    }
    //List all trip of a user
    @GetMapping("/{userId}/trips")
    public ResponseEntity<List<TripDto>> tripsByUser(@PathVariable String userId){
        List<TripDto> trips=this.tripService.tripByUser(userId);
        return new ResponseEntity<List<TripDto>>(trips,HttpStatus.OK);
    }
}
