package com.food.controller;

import com.food.entity.Farmer;
import com.food.service.farmer.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farmer")
public class FarmerController {

    @Autowired
    FarmerService farmerService;
    @PostMapping("/insert-farmer")
    public ResponseEntity<?> insertingFood(@RequestHeader(value = "userId",defaultValue = "unknown") String userId,@RequestBody Farmer farmer){
        Farmer savedObject = farmerService.insertFarmer(userId,farmer);
        return new ResponseEntity<>(savedObject, HttpStatus.CREATED);
    }
}
