package com.ratingservice.repository;

import com.ratingservice.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Long> {
    
    //custom finder method
    List<Rating> findByUserId(Long userId);

    List<Rating> findByHotelId(Long hotelId);


}
