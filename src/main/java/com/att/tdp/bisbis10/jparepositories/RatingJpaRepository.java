package com.att.tdp.bisbis10.jparepositories;

import com.att.tdp.bisbis10.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingJpaRepository extends JpaRepository<Rating, Integer> {
}
