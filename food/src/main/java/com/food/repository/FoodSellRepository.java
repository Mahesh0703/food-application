package com.food.repository;

import com.food.entity.FoodSell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodSellRepository extends JpaRepository <FoodSell,Integer> {
}
