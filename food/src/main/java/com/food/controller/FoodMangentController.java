package com.food.controller;

import com.food.entity.FoodStock;
import com.food.service.FoodMangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
public class FoodMangentController {

    @Autowired
    FoodMangementService foodMangementService;
    @GetMapping("/get-sample")
    public ResponseEntity<?> getSample(){
        return new ResponseEntity<>("Data Found", HttpStatus.FOUND);
    }

    @PostMapping("/insert-food")
    public ResponseEntity<?> insertingFood(@RequestHeader(value = "userId",defaultValue = "unknown") String userId,@RequestBody FoodStock foodStock){
        FoodStock savedObject = foodMangementService.insertFoodStock(userId,foodStock);
        return new ResponseEntity<>(savedObject,HttpStatus.CREATED);
    }
}
