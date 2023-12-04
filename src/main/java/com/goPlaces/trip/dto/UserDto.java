package com.goPlaces.trip.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.goPlaces.trip.entities.Trip;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private String id;

    @NotBlank
    private String name;

    @NotNull
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 70, message = "Age must be less than 70")
    private int age;

    @NotBlank
    @Pattern(regexp = "^[^0-9]+$", message = "Gender should not contain numbers")

    private String gender;

    @NotBlank
    @Size(min=8,max = 12,message = "Password must contain min 8 characters and max 12 characters")
    private String password;

    @Email
    private String email;

    @NotBlank
    @Pattern(regexp="^[0-9]{10}$", message="Please provide a valid 10-digit mobile number")

    private String mobNo;


    private Date dateCreated;


    private String createdBy;


    private String createdAt;


    @JsonIgnore
    private Set<Trip> tripSet=new HashSet<>();


}
