package com.goPlaces.trip.serviceImpl;

import com.goPlaces.trip.config.ModelMapperConfig;
import com.goPlaces.trip.dto.ListResponse;
import com.goPlaces.trip.dto.TripDto;
import com.goPlaces.trip.dto.UserDto;
import com.goPlaces.trip.entities.Trip;
import com.goPlaces.trip.entities.User;
import com.goPlaces.trip.exception.ResourceNotFoundException;
import com.goPlaces.trip.repository.TripRepository;
import com.goPlaces.trip.repository.UserRepository;
import com.goPlaces.trip.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=this.dtoToUser(userDto);
        User savedUser=this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto update(UserDto userDto){
        User user=this.modelMapper.map(userDto,User.class);
        return this.modelMapper.map(this.userRepository.save(user),UserDto.class);
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
        Page<User> userPage=userRepository.findAll(p);
        List<User> allUsers=userPage.getContent();
        List<UserDto> getUsers=allUsers.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        ListResponse listResponse =new ListResponse();

        listResponse.setContent(getUsers);
        listResponse.setLimit(userPage.getSize());
        listResponse.setPage(userPage.getNumber());
        listResponse.setTotal(userPage.getTotalPages());

        return listResponse;

    }

    @Override
    public UserDto getById(String id) {
        User user=this.userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "Id",id));

        return this.userToDto(user);
    }

    @Override
    public void delById(String id) {
        User user=this.userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "Id",id));
        this.userRepository.delete(user);


    }

    @Override
    public List<UserDto> search(String keyword) {
        List<User> users=this.userRepository.findByNameContaining(keyword);
        List<UserDto>userDtos=users.stream().map((user)->this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public List<UserDto> usersInTrip(String tripId){
        Trip trip=this.tripRepository.findById(tripId).orElseThrow(()-> new ResourceNotFoundException("Trip","id",tripId));
        List<User> users=this.userRepository.findByTripSet(trip);
        List<UserDto> userDtos=users.stream().map((user)-> this.modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
        return userDtos;

    }






    public User dtoToUser(UserDto userDto){
        User user=this.modelMapper.map(userDto, User.class);
        return user;
    }
    public UserDto userToDto(User user){
        UserDto userDto=this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
