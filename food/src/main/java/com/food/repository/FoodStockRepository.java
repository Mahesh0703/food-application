package com.food.repository;

import com.food.entity.FoodStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodStockRepository extends JpaRepository <FoodStock,Integer> {
}
