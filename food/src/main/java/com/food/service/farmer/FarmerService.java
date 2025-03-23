package com.food.service.farmer;

import com.food.entity.Farmer;

public interface FarmerService {
    Farmer insertFarmer(String userId, Farmer farmer);
}
