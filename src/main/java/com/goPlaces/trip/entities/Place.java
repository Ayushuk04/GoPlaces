package com.goPlaces.trip.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.goPlaces.trip.entities.placeDetails.PlaceAccommodation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="places")
public class Place {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator="system-uuid")
        @GenericGenerator(name="system-uuid", strategy = "uuid")
        private String id;

        @Column(name="state_name")
        private String stateName;
        @Column(name="place_name")
        private String placeName;

        @Column(name="description")

        private String desc;

        @Column(name="latitude")
        private Float latitude;

        @Column(name="longitude")
        private Float longitude;

        @JsonIgnore
        @ManyToMany(mappedBy = "assignedPlace")
        private Set<Trip> tripSet=new HashSet<>();

        @Column(name="date_created")
        private Date dateCreated;

        @Column(name="created_by")
        private String createdBy;

        @Column(name="created_at")
        private String createdAt;

        @OneToMany(mappedBy = "place",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
        private Set<PlaceAccommodation> accomodationsSet=new HashSet<>();

    }
