package com.goPlaces.trip.repository;
import java.util.List;

import com.goPlaces.trip.entities.Place;
import com.goPlaces.trip.entities.Trip;
import com.goPlaces.trip.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    List<User> findByNameContaining(String name);

    List<User> findByTripSet(Trip trip);




}
