package com.food.service.farmer;

import com.food.entity.Farmer;
import com.food.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerServiceImpl implements FarmerService {

    @Autowired
    FarmerRepository farmerRepository;
    @Override
    public Farmer insertFarmer(String userId, Farmer farmer) {
        //dealer.setDealerInsertedBy(userId);
        return farmerRepository.save(farmer);

    }
}
