package com.goPlaces.trip.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.goPlaces.trip.dto.TripDto;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String name;

    private int age;

    private String gender;

    private String password;

    private String email;
    @Column(name = "mobile_no")
    private BigInteger mobNo;

    @Column(name="date_created")
    private Date dateCreated;

    @Column(name="created_by")
    private String createdBy;

    @Column(name="created_at")
    private String createdAt;



    @JsonIgnore
    @ManyToMany(mappedBy = "assignedUser")
    private Set<Trip> tripSet=new HashSet<>();

    public User(){

    }


    public User(Set<Trip> tripSet,String id, String name, String password, int age, String gender, String email, BigInteger mobNo, Date dateCreated, String createdBy, String createdAt) {
        this.tripSet = tripSet;
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.mobNo = mobNo;
        this.dateCreated = dateCreated;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.password=password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Set<Trip> getTripSet() {
        return tripSet;
    }

    public void setTripSet(Set<Trip> tripSet) {
        this.tripSet = tripSet;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getMobNo() {
        return mobNo;
    }

    public void setMobNo(BigInteger mobNo) {
        this.mobNo = mobNo;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }


}
