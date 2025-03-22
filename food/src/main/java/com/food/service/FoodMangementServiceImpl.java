package com.food.service;

import com.food.entity.FoodStock;
import com.food.repository.FoodStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodMangementServiceImpl implements FoodMangementService {

    @Autowired
    FoodStockRepository foodMangementRepository;
    @Override
    public FoodStock insertFoodStock(String userId, FoodStock foodStock) {
        foodStock.setFoodInsertedBy(userId);
        return foodMangementRepository.save(foodStock);

    }
}
