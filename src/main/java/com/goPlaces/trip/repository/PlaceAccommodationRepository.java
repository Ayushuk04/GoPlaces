package com.goPlaces.trip.repository;

import com.goPlaces.trip.entities.placeDetails.PlaceAccommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceAccommodationRepository extends JpaRepository<PlaceAccommodation,String> {
}
