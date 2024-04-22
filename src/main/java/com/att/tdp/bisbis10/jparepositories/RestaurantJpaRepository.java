package com.att.tdp.bisbis10.jparepositories;

import java.util.List;

import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.projections.RestaurantProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantJpaRepository extends JpaRepository<Restaurant, Long> {

    List<RestaurantProjection> findAllProjectedBy();
    List<RestaurantProjection> findByCuisinesContaining(String cuisine);
}
