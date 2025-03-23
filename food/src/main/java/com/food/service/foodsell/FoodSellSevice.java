package com.food.service.foodsell;

import com.food.entity.FoodSell;

public interface FoodSellSevice {
    FoodSell insertSellingFood(String userId, FoodSell foodStock);
}
