package com.food.service.foodsell;

import com.food.entity.FoodSell;
import com.food.entity.FoodStock;
import com.food.repository.FoodSellRepository;
import com.food.service.foodstock.FoodStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class FoodSellServiceImpl implements FoodSellSevice{

    @Autowired
    FoodSellRepository foodSellRepository;

    @Autowired
    FoodStockService foodStockService;

    @Override
    @Transactional
    public FoodSell insertSellingFood(String userId, FoodSell foodSell) {

        foodSell.setFoodSellInsertedBy(userId);
        foodSell.setTotalAmount(calculateTotalAmount(foodSell.getSellingRate(),foodSell.getQty()));
        FoodSell savedFoodSell = foodSellRepository.save(foodSell);

        if (/*!Objects.isNull(savedFoodSell) */ savedFoodSell != null)
            foodStockService.updateSellingQty(userId, foodSell.getFoodStockId(), foodSell.getQty());

        return savedFoodSell ;

    }
    private static Double calculateTotalAmount(Double sellingRate,Integer qty){

        return sellingRate*qty;

    }
}
