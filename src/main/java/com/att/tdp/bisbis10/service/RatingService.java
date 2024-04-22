package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.jparepositories.RatingJpaRepository;
import com.att.tdp.bisbis10.model.Rating;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingJpaRepository ratingRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Transactional
    public void addRating(Long restaurantId, Double newRating) {
        Rating rating = new Rating();
        rating.setRating(newRating);
        rating.setRestaurantId(restaurantId);
        ratingRepository.save(rating);
        double newAverageRating = ratingRepository.calculateAverageRatingByRestaurantId(restaurantId);
        restaurantService.updateAverageRating(restaurantId, newAverageRating);
    }
}
