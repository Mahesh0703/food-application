package com.food.controller;

import com.food.entity.Dealer;
import com.food.service.dealer.DealerService;
import com.food.service.foodstock.FoodStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dealer")
public class DealerStockController {

    @Autowired
    FoodStockService foodMangementService;

    @Autowired
    DealerService dealerService;

    @PostMapping("/insert-dealer")
    public ResponseEntity<?> insertingFood(@RequestHeader(value = "userId",defaultValue = "unknown") String userId,@RequestBody Dealer dealer){
        Dealer savedObject = dealerService.insertDealer(userId,dealer);
        return new ResponseEntity<>(savedObject,HttpStatus.CREATED);
    }
}
