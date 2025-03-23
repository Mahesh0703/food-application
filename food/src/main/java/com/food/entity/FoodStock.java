package com.food.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "Food_Stock")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Transactional
public class FoodStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOOD_STOCK_ID")
    Integer foodStockId;
    @Column(name = "DEALER_CODE")
    Integer dealerCode;
    @Column(name = "FOOD_NAME")
    String foodName;
    @Column(name = "FOOD_ADDING_DATE")
    Date addingDate;
    @Column(name = "FOOD_QTY")
    Integer quantity;
    @Column(name = "FOOD_BUYING_RATE")
    Double buyingRate;
    @Column(name = "FOOD_SELLING_RATE")
    Double sellingRate;
    @Column(name = "FOOD_UPDATE_TIMESTAMP")
    LocalDateTime foodUpdateDateTime;
    @Column(name = "FOOD_INSERTED_BY")
    String foodInsertedBy;
    @Column(name = "FOOD_UPDATED_BY")
    String foodUpdatedBy;

    @PrePersist
    public void insertionTime(){
        this.addingDate = new Date();
    }
    @PreUpdate
    public void updateFoodTimeStamp(){
        if (this.foodUpdateDateTime == null ) {
            this.foodUpdateDateTime = LocalDateTime.now(); // Set the current time
        }
    }

}
