package com.food.repository;

import com.food.entity.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealerRepository extends JpaRepository <Dealer,Integer> {
}
