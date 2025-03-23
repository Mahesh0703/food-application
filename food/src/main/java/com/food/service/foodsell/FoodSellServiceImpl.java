package com.food.service.foodsell;

import com.food.entity.FoodSell;
import com.food.repository.FoodSellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodSellServiceImpl implements FoodSellSevice{

    @Autowired
    FoodSellRepository foodSellRepository;

    @Override
    public FoodSell insertSellingFood(String userId, FoodSell foodStock) {
        foodStock.setFoodSellInsertedBy(userId);
        foodStock.setTotalAmount(calculateTotalAmount(foodStock.getSellingRate(),foodStock.getQty()));
        return foodSellRepository.save(foodStock);
    }
    private static Double calculateTotalAmount(Double sellingRate,Integer qty){
        return sellingRate*qty;
    }
}
