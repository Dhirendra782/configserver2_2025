package com.ratingservice.serviceinterface;

import com.ratingservice.payload.RatingDto;

import java.util.List;

public interface RatingService {


    //create rating
    RatingDto createRating(RatingDto ratingDto);

    //Get rating list
    List<RatingDto> getAllRatings();

    //get rating by id
    List<RatingDto> getRatingByUserId(Long ratingId);


    //Get rating by user id
    List<RatingDto> getRatingByHotelId(Long hotelId);

}
