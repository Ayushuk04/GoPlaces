package com.goPlaces.trip.controller;

import com.goPlaces.trip.dto.ListResponse;
import com.goPlaces.trip.dto.TripDto;
import com.goPlaces.trip.dto.UserDto;
import com.goPlaces.trip.exception.ApiResponse;
import com.goPlaces.trip.exception.ResourceNotFoundException;
import com.goPlaces.trip.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Create User
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    //Update User

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser( @PathVariable String id,@Valid @RequestBody UserDto userDto){
        UserDto getUser=this.userService.getById(id);
        if(getUser==null){
            throw new ResourceNotFoundException("User","Id",id);

        }
        getUser=this.userService.update(userDto);
        return ResponseEntity.ok(getUser);

    }
    //Get users by id
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable String id){
        UserDto user=this.userService.getById(id);

        return ResponseEntity.ok(user);
    }
    //Delete users by id
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delUser(@PathVariable String id){
        UserDto user=this.userService.getById(id);
        if(user==null){
            throw new ResourceNotFoundException("User","Id",id);
        }
        this.userService.delById(id);
        return  ResponseEntity.ok(new ApiResponse("User deleted successfully",true));
    }
    //Get all users
    @GetMapping("/")
    public ResponseEntity<ListResponse> getAllUsers(@RequestParam(value="pageNumber", defaultValue = "0",required = false)int page,
                                                    @RequestParam(value="sortBy", defaultValue = "name",required = false)String sortBy,
                                                    @RequestParam(value = "limit", defaultValue = "7",required = false)int limit,
                                                    @RequestParam(value="sortDir", defaultValue = "asc", required = false)String sortDir)
    {
        return ResponseEntity.ok(this.userService.getAll(page, limit, sortBy, sortDir));


    }
    //Search users
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<UserDto>> searchUser(@PathVariable String keyword){
        List<UserDto> user=this.userService.search(keyword);
        return new ResponseEntity<List<UserDto>>(user,HttpStatus.OK);

    }

    @GetMapping("/{tripId}/users")
    public ResponseEntity<List<UserDto>> userInTrip(@PathVariable String tripId){
        List<UserDto> users=this.userService.usersInTrip(tripId);
        return new ResponseEntity<List<UserDto>>(users,HttpStatus.OK);
    }






}
