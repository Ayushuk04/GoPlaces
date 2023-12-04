package com.goPlaces.trip.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.goPlaces.trip.entities.Trip;
import com.goPlaces.trip.entities.placeDetails.PlaceAccommodation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDto {
    private String id;

    private String stateName;

    private String placeName;

    private String desc;

    private Float latitude;

    private Float longitude;
    @JsonIgnore
    private TripDto trip;

    private Date dateCreated;

    private String createdBy;

    private String createdAt;

    @JsonIgnore
    private Set<Trip> tripSet=new HashSet<>();


    private Set<PlaceAccommodation> accomodationsSet=new HashSet<>();

}
