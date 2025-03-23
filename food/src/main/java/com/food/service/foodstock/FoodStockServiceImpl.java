package com.food.service.foodstock;

import com.food.entity.FoodStock;
import com.food.repository.FoodStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodStockServiceImpl implements FoodStockService {

    @Autowired
    FoodStockRepository foodMangementRepository;

    @Override
    public FoodStock insertFoodStock(String userId, FoodStock foodStock) {
        foodStock.setFoodInsertedBy(userId);
        return foodMangementRepository.save(foodStock);

    }

    @Override
    public List<FoodStock> getFoodStockOnDealerCode(Integer dealerCode) {
        List<FoodStock> dealerFoodStock = foodMangementRepository.getFoodStockOnDealerCode(dealerCode);
        return dealerFoodStock;
    }

    @Override
    public List<FoodStock> allFoodStock() {
        return foodMangementRepository.findAll();
    }

    @Override
    public String updateSellingQty(String userId, Integer id, Integer quantity) {
        Integer updatedData = foodMangementRepository.updateFoodStock(id, quantity, userId);
        /*String message;
        Integer deletedDataCount = 0;
        if(updatedData > 0){
            deletedDataCount = foodMangementRepository.deleteZeroQtyStock(id,quantity);
        }
        if (deletedDataCount >0) {
            message="Qunatity removed because Stock is unavailable";
        }else {
            message = "Selled Quantity Updated ";
        }*/
        return Optional.of(updatedData).filter(data -> data > 0)
                .map(data -> {
                    Integer deletedDataCount = foodMangementRepository.deleteZeroQtyStock(id, quantity);
                    return deletedDataCount > 0
                            ? "Stock are unavailable"
                            : "Selled Quantity Updated";
                })
                .orElse("Stock are not updated");
    }
}
