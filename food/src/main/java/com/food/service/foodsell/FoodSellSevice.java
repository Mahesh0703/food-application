package com.food.service.foodsell;

import com.food.entity.FoodSell;

import java.io.IOException;
import java.util.List;

public interface FoodSellSevice {
    FoodSell insertSellingFood(String userId, FoodSell foodStock);

    List<FoodSell> retrieveSellRegister();

    byte[] exportExcel() throws IOException;
}
