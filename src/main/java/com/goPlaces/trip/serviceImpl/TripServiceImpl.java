package com.goPlaces.trip.serviceImpl;

import com.goPlaces.trip.dto.*;
import com.goPlaces.trip.dto.TripDto;
import com.goPlaces.trip.entities.Place;
import com.goPlaces.trip.entities.Trip;
import com.goPlaces.trip.entities.User;
import com.goPlaces.trip.exception.ResourceNotFoundException;
import com.goPlaces.trip.repository.PlaceRepository;
import com.goPlaces.trip.repository.TripRepository;
import com.goPlaces.trip.repository.TripRepository;
import com.goPlaces.trip.repository.UserRepository;
import com.goPlaces.trip.service.TripService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public TripDto createTrip(TripDto tripDto) {
        Trip trip=this.modelMapper.map(tripDto,Trip.class);

//        Place pl=this.placeRepository.findById(trip.getPlace().).orElseThrow(()->new ResourceNotFoundException("Trip","Id", trip.getPlace().getId()));
//        trip.setPlace(places);
        Trip savedTrip=this.tripRepository.save(trip);
        return this.modelMapper.map(savedTrip,TripDto.class);
    }

    @Override
    public ListResponse getAll(int page, int limit,String sortBy,String sortDir) {
        Sort sort= null;
        if (sortDir.equalsIgnoreCase("asc")) {
            sort = Sort.by(sortBy).ascending();
        }else{
            sort=Sort.by(sortBy).descending();

        }
        Pageable p= PageRequest.of(page, limit, sort);
        Page<Trip> userPage=tripRepository.findAll(p);
        List<Trip> allTrips=userPage.getContent();
        List<TripDto> getTrips=allTrips.stream().map((trip) -> this.modelMapper.map(trip,TripDto.class)).collect(Collectors.toList());
        ListResponse listResponse =new ListResponse();

        listResponse.setTripContent(getTrips);
        listResponse.setLimit(userPage.getSize());
        listResponse.setPage(userPage.getNumber());
        listResponse.setTotal(userPage.getTotalPages());

        return listResponse;

    }

    @Override
    public TripDto getById(String id) {
        Trip trip=this.tripRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Trip", "Id",id));

        return this.modelMapper.map(trip,TripDto.class);
    }

    @Override
    public void delById(String id) {
        Trip trip=this.tripRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Trip", "Id",id));
        this.tripRepository.delete(trip);


    }

    @Override
    public List<TripDto> search(String keyword) {
        List<Trip> trips=this.tripRepository.findByNameContaining(keyword);
        List<TripDto>tripDtos=trips.stream().map((trip)->this.modelMapper.map(trip, TripDto.class)).collect(Collectors.toList());
        return tripDtos;
    }

    @Override
    public TripDto assignUserToTrip(String tripId,String userId) {
        Set<User> userSet=null;
        Trip trip=this.tripRepository.findById(tripId).orElseThrow(()-> new ResourceNotFoundException("Trip","Id",tripId));
        User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        userSet=trip.getAssignedUser();
        userSet.add(user);
        trip.setAssignedUser(userSet);
        Trip savedTrip=this.tripRepository.save(trip);
        return this.modelMapper.map(savedTrip,TripDto.class);
    }

    @Override
    public TripDto assignPlaceToTrip(String tripId, String placeId){
        Set<Place> placeSet=null;
        Trip trip=this.tripRepository.findById(tripId).orElseThrow(()-> new ResourceNotFoundException("Trip","Id",tripId));
        Place place=this.placeRepository.findById(placeId).orElseThrow(()-> new ResourceNotFoundException("User","Id",placeId));
        placeSet=trip.getAssignedPlace();
        placeSet.add(place);
        trip.setAssignedPlace(placeSet);
        Trip savedTrip=this.tripRepository.save(trip);
        return this.modelMapper.map(savedTrip,TripDto.class);

    }

    @Override
    public void delUserFromTrip(String tripId,String userId){
        Trip trip=this.tripRepository.findById(tripId).orElseThrow(()-> new ResourceNotFoundException("Trip","Id",tripId));
        Set<User> userSet=trip.getAssignedUser();
        User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        userSet.remove(user);
        this.tripRepository.save(trip);
    }

    @Override
    public void delPlaceFromTrip(String tripId,String placeId){
        Trip trip=this.tripRepository.findById(tripId).orElseThrow(()-> new ResourceNotFoundException("Trip","Id",tripId));
        Set<Place> placeSet=trip.getAssignedPlace();
        Place place=this.placeRepository.findById(placeId).orElseThrow(()-> new ResourceNotFoundException("User","Id",placeId));
        placeSet.remove(place);
        this.tripRepository.save(trip);
    }
    @Override
    public List<TripDto> tripByUser(String userId){

        User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));

        List<Trip> trips=this.tripRepository.findByAssignedUser(user);
        List<TripDto> tripDtos= trips.stream().map((trip) -> this.modelMapper.map(trip, TripDto.class)).collect(Collectors.toList());
        return tripDtos;


    }
}
