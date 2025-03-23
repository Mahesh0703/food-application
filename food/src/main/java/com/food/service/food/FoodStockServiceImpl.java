package com.food.service.food;

import com.food.entity.FoodStock;
import com.food.repository.FoodStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodStockServiceImpl implements FoodStockService {

    @Autowired
    FoodStockRepository foodMangementRepository;
    @Override
    public FoodStock insertFoodStock(String userId, FoodStock foodStock) {
        foodStock.setFoodInsertedBy(userId);
        return foodMangementRepository.save(foodStock);

    }

    @Override
    public List<FoodStock> getFoodStockOnDealerCode(Integer dealerCode) {
        List<FoodStock> dealerFoodStock = foodMangementRepository.getFoodStockOnDealerCode(dealerCode);
        return dealerFoodStock;
    }

    @Override
    public List<FoodStock> allFoodStock() {
        return foodMangementRepository.findAll();
    }
}
