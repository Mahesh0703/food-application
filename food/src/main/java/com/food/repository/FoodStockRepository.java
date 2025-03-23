package com.food.repository;

import com.food.entity.FoodStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodStockRepository extends JpaRepository <FoodStock,Integer> {
    @Query("SELECT f FROM FoodStock f WHERE f.dealerCode = :dealerCode")
        // @Query("SELECT f FROM FoodStock f WHERE f.foodCode IN :foodCodes") ---for multiple dealerCode
    List<FoodStock> getFoodStockOnDealerCode(Integer dealerCode);
}
