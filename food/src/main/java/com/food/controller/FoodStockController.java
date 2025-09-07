package com.food.controller;

import com.food.entity.FoodStock;
import com.food.exception.StockNotAvailableForDealerException;
import com.food.service.foodstock.FoodStockService;
import com.food.utility.food.FoodStockPageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@Slf4j
public class FoodStockController {

    private final FoodStockService foodMangementService;

    public FoodStockController(FoodStockService foodMangementService){
        this.foodMangementService = foodMangementService;
    }

    @GetMapping("/get-sample")
    public ResponseEntity<?> getSample(){
        log.info("{} Fetching Sample Data",logPrefix());
        return new ResponseEntity<>("Data Found", HttpStatus.FOUND);
    }

    @PostMapping("/insert-food")
    public ResponseEntity<?> insertingFood(@RequestHeader(value = "userId",defaultValue = "unknown") String userId,@RequestBody FoodStock foodStock){
        log.info("{} Fetching Sample Data",logPrefix());
        FoodStock savedObject = foodMangementService.insertFoodStock(userId,foodStock);
        return new ResponseEntity<>(savedObject,HttpStatus.CREATED);
    }

    @GetMapping("/{dealerCode}")
    public ResponseEntity<?> getFoodStockOnDealerCode(@PathVariable Integer dealerCode) throws StockNotAvailableForDealerException {
        log.info("{} Fetching Sample Data",logPrefix());
        List<FoodStock> dealerFoodStock = foodMangementService.getFoodStockOnDealerCode(dealerCode);
        return new ResponseEntity<>(dealerFoodStock,HttpStatus.FOUND);
    }

    @GetMapping("/allStock")
    public ResponseEntity<?> allFoodStock(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size    ){
        log.info("{} Fetching All Stock ",logPrefix());
        Page<FoodStock> dealerFoodStock = foodMangementService.allFoodStock(PageRequest.of(page,size));
        FoodStockPageResponse response = new FoodStockPageResponse();
        response.setContent(dealerFoodStock.getContent());
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @PutMapping("/update-sell-qty")
    public ResponseEntity<?> updateSellQty(@RequestHeader (value = "userId",defaultValue = "unknown") String userId,
                                           @RequestParam Integer id,@RequestParam Integer quantity){
        log.info("{} Fetching Sample Data",logPrefix());
        String dataUpdatedStatus = foodMangementService.updateSellingQty(userId,id,quantity);
        return new ResponseEntity<>(dataUpdatedStatus,HttpStatus.OK);
    }

    private String logPrefix (){
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return "[" + this.getClass().getSimpleName() + "." + methodName + "]";
    }
}
