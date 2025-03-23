package com.food.repository;

import com.food.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository <Farmer,Integer> {
}
