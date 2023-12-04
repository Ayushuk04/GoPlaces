package com.goPlaces.trip.dto;
import com.goPlaces.trip.entities.placeDetails.PlaceAccommodation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ListResponse {

    private List<UserDto> content;
    private List<TripDto> tripContent;
    private List<PlaceDto> placeContent;
    private List<PlaceAccommodationDto> placeAccomodationContent;

    private Integer total;
    private Integer page;
    private Integer limit;


}
