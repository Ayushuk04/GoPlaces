package com.goPlaces.trip.service;

import com.goPlaces.trip.dto.ListResponse;
import com.goPlaces.trip.dto.PlaceAccommodationDto;

public interface PlaceAccommodationService {

    PlaceAccommodationDto createPlace(PlaceAccommodationDto placeAccommodationDto);

    ListResponse getAll(int page, int limit, String sortBy, String sortDir);

    PlaceAccommodationDto getById(String id);

    void delById(String id);
}
