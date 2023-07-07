package com.sha.springbootbookseller.controller;

import com.sha.springbootbookseller.model.PurchaseHistory;
import com.sha.springbootbookseller.security.UserPrincipal;
import com.sha.springbootbookseller.service.IPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchase-history")
public class PurchaseHistoryController {

    @Autowired
    IPurchaseHistoryService purchaseHistoryService;


    @PostMapping
    public ResponseEntity<?> savePurchaseHistory(@RequestBody PurchaseHistory purchaseHistory){
        return  new ResponseEntity<>(purchaseHistoryService.savePurchaseHistory(purchaseHistory), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?>  getAllPurchaseHistoryOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return ResponseEntity.ok(purchaseHistoryService.findPurchaseItemsOfUser(userPrincipal.getId()));
    }
}
