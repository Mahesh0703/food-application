package com.food.service.foodsell;

import com.food.entity.FoodSell;
import com.food.entity.FoodStock;
import com.food.repository.FoodSellRepository;
import com.food.service.foodstock.FoodStockService;
import com.food.utility.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class FoodSellServiceImpl implements FoodSellSevice{

    @Autowired
    FoodSellRepository foodSellRepository;

    @Autowired
    FoodStockService foodStockService;

    @Autowired
    ExcelExporter excelExporter;

    @Override
    @Transactional
    public FoodSell insertSellingFood(String userId, FoodSell foodSell) {

        foodSell.setFoodSellInsertedBy(userId);
        foodSell.setTotalAmount(calculateTotalAmount(foodSell.getSellingRate(),foodSell.getQty()));
        FoodSell savedFoodSell = foodSellRepository.save(foodSell);

        if (/*!Objects.isNull(savedFoodSell) */ savedFoodSell != null)
            foodStockService.updateSellingQty(userId, foodSell.getFoodStockId(), foodSell.getQty());

        return savedFoodSell ;

    }

    @Override
    public List<FoodSell> retrieveSellRegister() {
        return foodSellRepository.findAll();
    }

    @Override
    public byte[] exportExcel() throws IOException {
        List<FoodSell> sellRegisterData = foodSellRepository.findAll();
        ByteArrayOutputStream excelFile =excelExporter.exportSellFoodRegisterToExcel(sellRegisterData);
        return excelFile.toByteArray();
    }

    private static Double calculateTotalAmount(Double sellingRate,Integer qty){

        return sellingRate*qty;

    }
}
