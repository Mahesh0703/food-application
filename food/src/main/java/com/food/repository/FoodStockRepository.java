package com.food.repository;

import com.food.entity.FoodStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FoodStockRepository extends JpaRepository <FoodStock,Integer> {
    @Query("SELECT f FROM FoodStock f WHERE f.dealerCode = :dealerCode")
        // @Query("SELECT f FROM FoodStock f WHERE f.foodCode IN :foodCodes") ---for multiple dealerCode
    List<FoodStock> getFoodStockOnDealerCode(Integer dealerCode);

    @Modifying
    @Transactional
    @Query("UPDATE FoodStock fs SET fs.quantity = fs.quantity - :quantity, fs.foodUpdatedBy = :foodUpdatedBy WHERE fs.foodStockId = :foodStockId")
    Integer updateFoodStock(@Param("foodStockId") Integer id, @Param("quantity") Integer quantity, @Param("foodUpdatedBy") String updatedBy);

    @Modifying
    @Transactional
    @Query("DELETE FROM FoodStock fs where fs.foodStockId = foodStockId and fs.quantity = 0")
    Integer deleteZeroQtyStock(@Param("foodStockId") Integer id, @Param("quantity") Integer quantity);
}
