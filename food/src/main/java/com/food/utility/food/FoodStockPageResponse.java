package com.food.utility.food;

import com.food.entity.FoodStock;
import lombok.Data;

import java.util.List;

@Data
public class FoodStockPageResponse {

    private List<FoodStock> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean lastPage;
}
