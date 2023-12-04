package com.goPlaces.trip.service;

import com.goPlaces.trip.dto.ListResponse;
import com.goPlaces.trip.dto.TripDto;
import com.goPlaces.trip.dto.UserDto;
import com.goPlaces.trip.entities.User;

import java.util.List;

public interface UserService {

    UserDto  createUser(UserDto userDto);

    UserDto update(UserDto userDto);

    ListResponse getAll(int page, int limit,String sortBy,String sortDir);

    UserDto getById(String id);

    void delById(String id);

    List<UserDto> search(String keyword);

    List<UserDto> usersInTrip(String tripId);




}
