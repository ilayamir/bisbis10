package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.Map;

@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/ratings")
    public ResponseEntity<Void> addRating(@RequestBody Map<String, Object> ratingData) {
        Integer restaurantId = (Integer) ratingData.get("restaurantId");
        Double rating = (Double)(ratingData.get("rating"));

        ratingService.addRating(restaurantId, rating);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

