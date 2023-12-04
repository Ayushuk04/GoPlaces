package com.goPlaces.trip.entities.placeDetails;

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
@Entity
@Table(name="place_accommodation")
public class PlaceAccommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;


    @ManyToOne
    @JsonIgnore
    private Place place;

    @Column(name="property_name")
    private String propertyName;

    @Column(name="description",length = 2000)
    private String desc;

    @Column(name="address")
    private String address;


    @Column(name="booking_link")
    private String booking_link;

    @Column(name="images")
    private String images;


    @Column(name="created_at")
    private String createdAt;
    @Column(name="created_by")
    private String createdBy;
    @Column(name="date_created")
    private Date dateCreated;

}
