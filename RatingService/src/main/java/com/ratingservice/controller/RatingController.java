package com.ratingservice.controller;


import com.ratingservice.payload.RatingDto;
import com.ratingservice.serviceinterface.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
@AllArgsConstructor
public class RatingController {

    private RatingService ratingService;

    //create rating
    @PostMapping
    public ResponseEntity<RatingDto> createRating(@RequestBody RatingDto ratingDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(ratingDto));
    }

    //Get all rating list
    @GetMapping
    public ResponseEntity<List<RatingDto>> getAllRating() {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatings());
    }

    //get rating by user id
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<RatingDto>> getRatingById(@PathVariable("userId") Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
    }

    //get rating by hotel id
    @GetMapping("hotels/{hotelId}")
    public ResponseEntity<List<RatingDto>> getRatingByHotelId(@PathVariable("hotelId") Long hotelId) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hotelId));
    }

}
