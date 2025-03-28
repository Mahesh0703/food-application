package com.food.service.foodstock;

import com.food.entity.FoodStock;

import java.util.List;

public interface FoodStockService {
    FoodStock insertFoodStock(String userId, FoodStock foodStock);

    List<FoodStock> getFoodStockOnDealerCode(Integer dealerCode);

    List<FoodStock> allFoodStock();

    String updateSellingQty(String userId, Integer id, Integer quantity);
}
