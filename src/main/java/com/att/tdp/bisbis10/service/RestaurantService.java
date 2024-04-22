package com.att.tdp.bisbis10.service;
import com.att.tdp.bisbis10.jparepositories.RestaurantJpaRepository;
import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.projections.RestaurantProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantJpaRepository restaurantJpaRepo;

    public List<RestaurantProjection> getAllRestaurants(){
        return restaurantJpaRepo.findAllProjectedBy();
    }

    public List<RestaurantProjection> getRestaurantsByCuisine(String cuisine){
        return restaurantJpaRepo.findByCuisinesContaining(cuisine);
    }
    public Restaurant getRestaurantById(Long id) {
        return restaurantJpaRepo.findById(id).orElse(null);
    }
    public void addRestaurant(Restaurant restaurant){
        restaurantJpaRepo.save(restaurant);
    }
    public void updateRestaurant(Long id, Restaurant restaurant){
        Optional<Restaurant> existingRestaurantOptional = restaurantJpaRepo.findById(id);
        if (existingRestaurantOptional.isPresent()){
            existingRestaurantOptional.get().setCuisines(restaurant.getCuisines());
            restaurantJpaRepo.save(existingRestaurantOptional.get());
        }
    }
    public void updateAverageRating(Long restaurantId, double newAverageRating) {
        Optional<Restaurant> optionalRestaurant = restaurantJpaRepo.findById(restaurantId);
        optionalRestaurant.ifPresent(restaurant -> {
            restaurant.setAverageRating(newAverageRating);
            restaurantJpaRepo.save(restaurant);
        });
    }
    public void deleteRestaurant(Long id){
        restaurantJpaRepo.deleteById(id);
    }
}
