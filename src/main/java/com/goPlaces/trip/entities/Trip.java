package com.goPlaces.trip.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Time;
import java.util.*;

@Entity
@Table(name="trips")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String name;


    @Column(name="description")
    private String desc;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    private Time departureTime;

    private String pickupPoint;

    @Column(name="essentials")
    private String tripEssentials;

    @Column(name="date_created")
    private Date dateCreated;

    @Column(name="created_by")
    private String createdBy;

    @Column(name="created_at")
    private String createdAt;


    @ManyToMany
    @JoinTable(name = "trip_place",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id")
    )
    private Set<Place> assignedPlace=new HashSet<>();


    @ManyToMany
    @JoinTable(name = "trip_user",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> assignedUser=new HashSet<>();







}
