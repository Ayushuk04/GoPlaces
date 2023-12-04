package com.goPlaces.trip.repository;

import com.goPlaces.trip.entities.Place;
import com.goPlaces.trip.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place,String> {




}
