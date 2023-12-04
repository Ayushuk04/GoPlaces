package com.goPlaces.trip.serviceImpl;

import com.goPlaces.trip.config.ModelMapperConfig;
import com.goPlaces.trip.dto.ListResponse;
import com.goPlaces.trip.dto.PlaceAccommodationDto;
import com.goPlaces.trip.dto.PlaceDto;
import com.goPlaces.trip.entities.placeDetails.PlaceAccommodation;
import com.goPlaces.trip.exception.ResourceNotFoundException;
import com.goPlaces.trip.repository.PlaceAccommodationRepository;
import com.goPlaces.trip.service.PlaceAccommodationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceAccommodationServiceImpl implements PlaceAccommodationService {


    @Autowired
    private PlaceAccommodationRepository placeAccommodationRepository;


    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PlaceAccommodationDto createPlace(PlaceAccommodationDto placeAccommodationDto) {
        PlaceAccommodation place=this.modelMapper.map(placeAccommodationDto,PlaceAccommodation.class);
        PlaceAccommodation savedAccommodation=this.placeAccommodationRepository.save(place);

        return this.modelMapper.map(savedAccommodation,PlaceAccommodationDto.class);
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
        Page<PlaceAccommodation> userPage= placeAccommodationRepository.findAll(p);
        List<PlaceAccommodation> allPlaces=userPage.getContent();
        List<PlaceAccommodationDto> getPlaces=allPlaces.stream().map((place) -> this.modelMapper.map(place,PlaceAccommodationDto.class)).collect(Collectors.toList());

        ListResponse listResponse =new ListResponse();

        listResponse.setPlaceAccomodationContent(getPlaces);
        listResponse.setLimit(userPage.getSize());
        listResponse.setPage(userPage.getNumber());
        listResponse.setTotal(userPage.getTotalPages());

        return listResponse;

    }

    @Override
    public PlaceAccommodationDto getById(String id) {
        PlaceAccommodation place=this.placeAccommodationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Accomodation","id",id));
        return this.modelMapper.map(place,PlaceAccommodationDto.class);
    }

    @Override
    public void delById(String id) {
        this.placeAccommodationRepository.deleteById(id);

    }
}
