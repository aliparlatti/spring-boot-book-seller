package com.sha.springbootbookseller.repository;

import com.sha.springbootbookseller.model.PurchaseHistory;
import com.sha.springbootbookseller.repository.projection.IPurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPurchaseRepository  extends JpaRepository<PurchaseHistory,Long > {

    @Query("select " + "b.title as title, ph.price as price, ph.purchaseTime as purchaseTime " +
    "from  PurchaseHistory ph left join Book  b on b.id=ph.bookID " +
    "where ph.userID=:userId"
    )
    List<IPurchaseItem> findPurchasesOfUser(@Param("userId") Long userId);
}
