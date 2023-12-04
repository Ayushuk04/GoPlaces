package com.goPlaces.trip.serviceImpl;

import com.goPlaces.trip.dto.ListResponse;
import com.goPlaces.trip.dto.PlaceDto;
import com.goPlaces.trip.entities.Place;
import com.goPlaces.trip.entities.Trip;
import com.goPlaces.trip.entities.User;
import com.goPlaces.trip.entities.placeDetails.PlaceAccommodation;
import com.goPlaces.trip.exception.ResourceNotFoundException;
import com.goPlaces.trip.repository.PlaceAccommodationRepository;
import com.goPlaces.trip.repository.PlaceRepository;
import com.goPlaces.trip.repository.TripRepository;
import com.goPlaces.trip.service.PlaceService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private PlaceAccommodationRepository placeAccommodationRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public PlaceDto createPlace(PlaceDto placeDto) {
        Place place=this.modelMapper.map(placeDto,Place.class);
        Place savedPlace=this.placeRepository.save(place);
        return this.modelMapper.map(savedPlace,PlaceDto.class);
    }

    @Override
    public PlaceDto update(PlaceDto placeDto){
        Place place=this.modelMapper.map(placeDto,Place.class);
        return this.modelMapper.map(this.placeRepository.save(place),PlaceDto.class);

    }
    @Override
    public ListResponse getAll(int page, int limit, String sortBy, String sortDir) {
        Sort sort= null;
        if (sortDir.equalsIgnoreCase("asc")) {
            sort = Sort.by(sortBy).ascending();
        }else{
            sort=Sort.by(sortBy).descending();

        }
        Pageable p= PageRequest.of(page, limit, sort);
        Page<Place> userPage=placeRepository.findAll(p);
        List<Place> allPlaces=userPage.getContent();
        List<PlaceDto> getPlaces=allPlaces.stream().map((place) -> this.modelMapper.map(place,PlaceDto.class)).collect(Collectors.toList());
        ListResponse listResponse =new ListResponse();

        listResponse.setPlaceContent(getPlaces);
        listResponse.setLimit(userPage.getSize());
        listResponse.setPage(userPage.getNumber());
        listResponse.setTotal(userPage.getTotalPages());

        return listResponse;

    }

    @Override
    public PlaceDto getById(String id) {
        Place place=this.placeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Place", "Id",id));

        return this.modelMapper.map(place,PlaceDto.class);
    }

    @Override
    public void delById(String id) {
        Place place=this.placeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Place", "Id",id));
        this.placeRepository.delete(place);


    }

    @Override
    public PlaceDto assignAccommodationToPlace(String placeId, String accommodationId){
        Set<PlaceAccommodation> accommodations=null;
        Place place=this.placeRepository.findById(placeId).orElseThrow(()-> new ResourceNotFoundException("Place","Id",placeId));
        PlaceAccommodation placeAccommodation=this.placeAccommodationRepository.findById(accommodationId).orElseThrow(()-> new ResourceNotFoundException("Accommodation","Id",accommodationId));
        accommodations=place.getAccomodationsSet();
        accommodations.add(placeAccommodation);
        place.setAccomodationsSet(accommodations);
        placeAccommodation.setPlace(place);
        Place savedPlace=this.placeRepository.save(place);
        return this.modelMapper.map(savedPlace,PlaceDto.class);

    }
    @Override
    public void delAccommodationFromPlace(String placeId,String accommodationId){
        Place place=this.placeRepository.findById(placeId).orElseThrow(()-> new ResourceNotFoundException("Place","Id",placeId));
        Set<PlaceAccommodation> placeSet=place.getAccomodationsSet();
        PlaceAccommodation placeAccommodation=this.placeAccommodationRepository.findById(accommodationId).orElseThrow(()-> new ResourceNotFoundException("Accommodation","Id",accommodationId));
        placeSet.remove(placeAccommodation);
        this.placeRepository.save(place);
    }

//    @Override
//    public List<PlaceDto> getPlacesByTrip(String tripId){
//        Trip trip=this.tripRepository.findById(tripId).orElseThrow(()-> new ResourceNotFoundException("Trip","id",tripId));
//        List<Place> places=this.placeRepository.findByTrip(trip);
//        List<PlaceDto> placeDtos= places.stream().map((place) -> this.modelMapper.map(place, PlaceDto.class)).collect(Collectors.toList());
//        return placeDtos;
//
//    }

//    @Override
//    public List<PlaceDto> search(String keyword) {
//        List<Place> places=this.placeRepository.findByNameContaining(keyword);
//        List<PlaceDto>placeDtos=places.stream().map((user)->this.modelMapper.map(user, PlaceDto.class)).collect(Collectors.toList());
//        return placeDtos;
//    }

}
