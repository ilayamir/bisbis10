package com.att.tdp.bisbis10.model;

import java.util.List;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double averageRating;
    private boolean isKosher;
    @ElementCollection
    private List<String> cuisines;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Dish> dishes;
    public Restaurant() {
        super();
    }
    public Restaurant(Long id, String name, double averageRating, Boolean isKosher, List<String> cuisines) {
        super();
        this.id = id;
        this.name = name;
        this.averageRating = averageRating;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public Long getId(){return id;}

    public void setId(Long id){this.id = id;}

    public String getName(){return name;}

    public void setName(String name) {this.name = name;}

    public double getAverageRating(){return averageRating;}

    public void setAverageRating(double averageRating){this.averageRating = averageRating;}

    public boolean getIsKosher(){return this.isKosher;}

    public void setIsKosher(boolean isKosher){this.isKosher = isKosher;}

    public List<String> getCuisines(){return cuisines;}

    public void setCuisines(List<String> cuisines){this.cuisines = cuisines;}

    public List<Dish> getDishes(){return dishes;}

    public void setDishes(List<Dish> dishes){this.dishes = dishes;}
}

