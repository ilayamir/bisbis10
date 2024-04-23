package com.att.tdp.bisbis10.jparepositories;

import com.att.tdp.bisbis10.model.Dish;
import com.att.tdp.bisbis10.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishJpaRepository extends JpaRepository<Dish, Integer> {
    List<Dish> findByRestaurant(Restaurant restaurant);
}

