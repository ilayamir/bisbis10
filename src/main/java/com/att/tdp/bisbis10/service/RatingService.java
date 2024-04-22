package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.jparepositories.RatingJpaRepository;
import com.att.tdp.bisbis10.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class RatingService {

    @Autowired
    private RatingJpaRepository ratingRepository;

    public void addRating(Integer restaurantId, Double rating) {
        Rating newRating = new Rating(restaurantId,rating);
        ratingRepository.save(newRating);
        //Extra - update the restaurant's rating
    }
}
