package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.jparepositories.RatingJpaRepository;
import com.att.tdp.bisbis10.model.Rating;
import com.att.tdp.bisbis10.model.Restaurant;
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
    public void addRating(Rating rating, Restaurant restaurant) {
        rating.setRestaurant(restaurant);
        ratingRepository.save(rating);
        Long restaurantId = rating.getRestaurantId();
        Double newAverageRating = ratingRepository.calculateAverageRatingByRestaurantId(restaurantId);
        restaurantService.updateAverageRating(restaurantId, newAverageRating);
    }
}
