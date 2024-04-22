package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.model.Rating;
import com.att.tdp.bisbis10.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/ratings")
    public ResponseEntity<Void> addRating(@RequestBody Rating ratingData) {
        Long restaurantId = ratingData.getRestaurantId();
        Double rating = ratingData.getRating();
        ratingService.addRating(restaurantId, rating);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

