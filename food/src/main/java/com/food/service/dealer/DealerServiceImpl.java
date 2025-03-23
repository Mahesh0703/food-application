package com.food.service.dealer;

import com.food.entity.Dealer;
import com.food.repository.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealerServiceImpl implements DealerService {

    @Autowired
    DealerRepository dealerRepository;
    @Override
    public Dealer insertDealer(String userId, Dealer dealer) {
        dealer.setDealerInsertedBy(userId);
        return dealerRepository.save(dealer);

    }
}
