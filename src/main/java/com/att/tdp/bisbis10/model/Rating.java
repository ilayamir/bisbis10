package com.att.tdp.bisbis10.model;
import jakarta.persistence.*;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Long restaurantId;
    private Double rating;

    public Rating(){
        super();
    }
    public Rating(Long restaurantId, Double rating){
        super();
        this.restaurantId = restaurantId;
        this.rating = rating;
    }

    public int getId(){return id;}

    public void setId(int id){this.id = id;}

    public Long getRestaurantId(){return restaurantId;}

    public void setRestaurantId(Long restaurantId){this.restaurantId = restaurantId;}

    public Double getRating(){return rating;}

    public void setRating(Double rating){this.rating = rating;}
}
