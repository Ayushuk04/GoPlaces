package com.goPlaces.trip.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.goPlaces.trip.entities.Place;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceAccommodationDto {

    private String id;

    private String propertyName;

    private String desc;

    private String address;

    @JsonIgnore
    private Place place;

    private String booking_link;

    private String images;


    private String createdAt;

    private String createdBy;

    private Date dateCreated;

}
