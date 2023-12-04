package com.goPlaces.trip.service;

import com.goPlaces.trip.dto.ListResponse;
import com.goPlaces.trip.dto.TripDto;
import com.goPlaces.trip.dto.UserDto;

import java.util.List;
import java.util.Set;

public interface TripService {

    TripDto createTrip(TripDto tripDto);

    ListResponse getAll(int page, int limit, String sortBy, String sortDir);

    TripDto getById(String id);

    void delById(String id);

    List<TripDto> search(String keyword);

    TripDto assignUserToTrip(String tripId,String userId);

    TripDto assignPlaceToTrip(String tripId,String placeId);

    void delUserFromTrip(String tripId,String userId);
    void delPlaceFromTrip(String tripId,String placeId);

    List<TripDto> tripByUser(String userID);




}
