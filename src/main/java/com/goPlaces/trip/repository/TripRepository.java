package com.goPlaces.trip.repository;

import com.goPlaces.trip.entities.Trip;
import com.goPlaces.trip.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface TripRepository extends JpaRepository<Trip, String> {
    List<Trip> findByNameContaining(String name);
    List<Trip> findByAssignedUser(User user);


}
