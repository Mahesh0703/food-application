package com.food.service;

import com.food.entity.FoodStock;

public interface FoodMangementService {
    FoodStock insertFoodStock(String userId, FoodStock foodStock);
}
