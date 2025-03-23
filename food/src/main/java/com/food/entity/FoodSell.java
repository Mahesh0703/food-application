package com.food.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Entity
@Table(name = "Food_Sell_Details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Transactional
public class FoodSell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOOD_SELL_ID")
    Integer foodsellId;
    @Column(name ="FOOD_FRM_ID")
    Integer farmerId;
    @Column(name ="FOOD_FRM_NAME")
    String farmerName;
    @Column(name ="FOOD_PRODUCT_NAME")
    String productName;
    @Column(name ="FOOD_QTY")
    Integer qty;
    @Column(name ="FOOD_SELLING_RATE")
    Double sellingRate;
    @Column(name ="FOOD_TOTAL_AMOUNT")
    Double totalAmount;
    @Column(name ="FOOD_RECIEPT_NO")
    String recieptNo;
    @Column(name ="FOOD_STATUS")
    String paymentStatus;
    @Column(name = "FOOD_SELL_INSERTED_BY")
    String foodSellInsertedBy;
    @Column(name = "FOOD_INSERTED_DATE")
    Date foodInsertedDate;

    @PrePersist
    public void foodInsertedDate(){
        this.foodInsertedDate = new Date();
    }

}
