package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.jparepositories.DishJpaRepository;
import com.att.tdp.bisbis10.jparepositories.RestaurantJpaRepository;
import com.att.tdp.bisbis10.model.Dish;
import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.projections.DishProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {
    @Autowired
    private DishJpaRepository dishJpaRepo;
    @Autowired
    private RestaurantJpaRepository restaurantJpaRepo;
    public void addDish(Long restaurantId, Dish dish) {
        Optional<Restaurant> parentRestaurant = restaurantJpaRepo.findById(restaurantId);
        if (parentRestaurant.isPresent()){
            dish.setRestaurant(parentRestaurant.get());
            this.dishJpaRepo.save(dish);
        }
    }

    public void updateDish(int dishId, Dish changed_dish) {
        Optional<Dish> optionalDish = dishJpaRepo.findById(dishId);
        if (optionalDish.isPresent()) {
            Dish dish = optionalDish.get();
            dish.setDescription(changed_dish.getDescription());
            dish.setPrice(changed_dish.getPrice());
            dishJpaRepo.save(dish);
        }
    }

    public void deleteDish(Long restaurantId, int dishId) {
        dishJpaRepo.deleteById(dishId);
    }

    public List<DishProjection> getDishesByRestaurant(Long restaurantId) {
        Optional<Restaurant> restaurant = restaurantJpaRepo.findById(restaurantId);
        return restaurant.map(value -> dishJpaRepo.findByRestaurant(value)).orElse(null);
    }
}

