package com.food.service.foodstock;

import com.food.entity.FoodStock;
import com.food.exception.StockNotAvailableForDealerException;

import java.util.List;

public interface FoodStockService {
    FoodStock insertFoodStock(String userId, FoodStock foodStock);

    List<FoodStock> getFoodStockOnDealerCode(Integer dealerCode) throws StockNotAvailableForDealerException;

    List<FoodStock> allFoodStock();

    String updateSellingQty(String userId, Integer id, Integer quantity);
}
