package com.goPlaces.trip.service;

import com.goPlaces.trip.dto.ListResponse;
import com.goPlaces.trip.dto.PlaceDto;
import com.goPlaces.trip.dto.TripDto;

import java.util.List;

public interface PlaceService{
    PlaceDto createPlace(PlaceDto placeDto);

    PlaceDto update(PlaceDto placeDto);

    ListResponse getAll(int page, int limit, String sortBy, String sortDir);

    PlaceDto getById(String id);

    void delById(String id);

    void delAccommodationFromPlace(String placeId,String accommodationId);

    PlaceDto assignAccommodationToPlace(String placeId,String accommodationId);



//    List<PlaceDto> getPlacesByTrip(String tripId);

//    List<PlaceDto> search(String keyword);
}
