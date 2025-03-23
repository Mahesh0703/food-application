package com.food.controller;

import com.food.entity.FoodStock;
import com.food.service.foodstock.FoodStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodStockController {

    @Autowired
    FoodStockService foodMangementService;
    @GetMapping("/get-sample")
    public ResponseEntity<?> getSample(){
        return new ResponseEntity<>("Data Found", HttpStatus.FOUND);
    }

    @PostMapping("/insert-food")
    public ResponseEntity<?> insertingFood(@RequestHeader(value = "userId",defaultValue = "unknown") String userId,@RequestBody FoodStock foodStock){
        FoodStock savedObject = foodMangementService.insertFoodStock(userId,foodStock);
        return new ResponseEntity<>(savedObject,HttpStatus.CREATED);
    }
    @GetMapping("/{dealerCode}")
    public ResponseEntity<?> getFoodStockOnDealerCode(@PathVariable Integer dealerCode){
        List<FoodStock> dealerFoodStock = foodMangementService.getFoodStockOnDealerCode(dealerCode);
        return new ResponseEntity<>(dealerFoodStock,HttpStatus.FOUND);
    }
    @GetMapping("/allStock")
    public ResponseEntity<?> allFoodStock(){
        List<FoodStock> dealerFoodStock = foodMangementService.allFoodStock();
        return new ResponseEntity<>(dealerFoodStock,HttpStatus.FOUND);
    }
    @PutMapping("/update-sell-qty")
    public ResponseEntity<?> updateSellQty(@RequestHeader (value = "userId",defaultValue = "unknown") String userId,
                                           @RequestParam Integer id,@RequestParam Integer quantity){
        String dataUpdatedStatus = foodMangementService.updateSellingQty(userId,id,quantity);
        System.out.println("******"+dataUpdatedStatus);
        return new ResponseEntity<>(dataUpdatedStatus,HttpStatus.OK);

    }
}
