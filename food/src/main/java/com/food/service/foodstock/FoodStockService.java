package com.food.service.foodstock;

import com.food.entity.FoodStock;
import com.food.exception.StockNotAvailableForDealerException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FoodStockService {
    FoodStock insertFoodStock(String userId, FoodStock foodStock);

    List<FoodStock> getFoodStockOnDealerCode(Integer dealerCode) throws StockNotAvailableForDealerException;

    Page<FoodStock> allFoodStock(Pageable pageable);

    String updateSellingQty(String userId, Integer id, Integer quantity);
}
