package com.food.controller;

import com.food.entity.FoodSell;
import com.food.service.foodsell.FoodSellSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/food-sell")
public class FoodSellController {

    @Autowired
    FoodSellSevice foodSellSevice;

    @PostMapping("/insert-selling-food")
    public ResponseEntity<?> insertSellingFood(@RequestHeader(value = "userId",defaultValue = "unknown") String userId, @RequestBody FoodSell foodSell){
        FoodSell savedSellingFood = foodSellSevice.insertSellingFood(userId,foodSell);
        return new ResponseEntity<>(savedSellingFood, HttpStatus.CREATED);
    }

    @GetMapping("/all-selling-register")
    public ResponseEntity<?> retrieveSellFoodRegister(){
        List<FoodSell> sellRegister = foodSellSevice.retrieveSellRegister();
        return new ResponseEntity<>(sellRegister,HttpStatus.FOUND);
    }

    @GetMapping("/sellregister-export")
    public ResponseEntity<?> exportSellRegister() throws IOException {

        byte[] excel = foodSellSevice.exportExcel();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=food_sell_register.xlsx");
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);

        return new ResponseEntity<>(excel,headers,HttpStatus.OK);
    }
}
