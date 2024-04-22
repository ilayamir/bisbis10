package com.att.tdp.bisbis10.projections;

import java.util.List;

public interface RestaurantProjection {
    Long getId();
    String getName();
    double getAverageRating();
    boolean getIsKosher();
    List<String> getCuisines();
}
