package com.ratingservice.service.impl;

import com.ratingservice.exception.ResourceNotFoundException;
import com.ratingservice.model.Rating;
import com.ratingservice.payload.RatingDto;
import com.ratingservice.repository.RatingRepository;
import com.ratingservice.serviceinterface.RatingService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;

    private ModelMapper modelMapper;

    //create rating
    @Override
    public RatingDto createRating(RatingDto ratingDto) {
        Rating rating = modelMapper.map(ratingDto,Rating.class);
        Rating saveRating = ratingRepository.save(rating);
        return modelMapper.map(saveRating, RatingDto.class);
    }

    //get all rating list
    @Override
    public List<RatingDto> getAllRatings() {
        List<Rating> ratings = ratingRepository.findAll();
        return ratings.stream().map(rating -> modelMapper.map(rating,RatingDto.class)).collect(Collectors.toList());
    }

    //get rating by id
    @Override
    public List<RatingDto> getRatingByUserId(Long userId) {
        List<Rating> ratings = ratingRepository.findByUserId(userId);
        if(ratings.isEmpty()) {
            throw new RuntimeException("No Rating found with user id: "+userId);
        }
        return ratings.stream().map(rating -> modelMapper.map(rating,RatingDto.class)).collect(Collectors.toList());
    }

    //Get rating by hotel id
    @Override
    public List<RatingDto> getRatingByHotelId(Long hotelId) {
        List<Rating> ratings = ratingRepository.findByHotelId(hotelId);
        if(ratings.isEmpty()) {
            throw new RuntimeException("no rating found with ID: "+hotelId);
        }
        return ratings.stream().map(rating -> modelMapper.map(rating,RatingDto.class)).collect(Collectors.toList());
    }

}
