package com.goPlaces.trip.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.goPlaces.trip.entities.Place;
import com.goPlaces.trip.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {

    private String id;
    private String name;

    private String desc;

    private Date startDate;

    private Date endDate;
    private Time departureTime;

    private String pickupPoint;

    private String tripEssentials;

    private Date dateCreated;

    private String createdBy;

    private String createdAt;


    private Set<Place> assignedPlace=new HashSet<>();
    private Set<User> assignedUser=new HashSet<>();





}
