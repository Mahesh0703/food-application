package com.food.controller;

import com.food.entity.FoodSell;
import com.food.service.foodsell.FoodSellSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food-sell")
public class FoodSellController {

    @Autowired
    FoodSellSevice foodSellSevice;

    @PostMapping("/insert-selling-food")
    public ResponseEntity<?> insertSellingFood(@RequestHeader(value = "userId",defaultValue = "unknown") String userId, @RequestBody FoodSell foodStock){
        FoodSell savedSellingFood = foodSellSevice.insertSellingFood(userId,foodStock);
        return new ResponseEntity<>(savedSellingFood, HttpStatus.CREATED);
    }
}
