package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.PurchaseHistory;
import com.sha.springbootbookseller.repository.IPurchaseRepository;
import com.sha.springbootbookseller.repository.projection.IPurchaseItem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryService implements IPurchaseHistoryService{
    private final IPurchaseRepository purchaseRepository;

    public PurchaseHistoryService(IPurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }
    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return  purchaseRepository.save(purchaseHistory);
    }
    @Override
    public List<IPurchaseItem> findPurchaseItemsOfUser(Long userId){
        return purchaseRepository.findPurchasesOfUser(userId);
    }
}
