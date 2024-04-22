package com.att.tdp.bisbis10.model;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int restaurantId;
    private Double rating;
    public Rating(int restaurantId, Double rating){
        this.restaurantId = restaurantId;
        this.rating = rating;
    }

    public int getId(){return id;}

    public void setId(int id){this.id = id;}

    public int getRestaurant_id(){return restaurantId;}

    public void setRestaurant_id(int restaurant_id){this.restaurantId = restaurant_id;}

    public Double getRating(){return rating;}

    public void setRating(Double rating){this.rating = rating;}
}
