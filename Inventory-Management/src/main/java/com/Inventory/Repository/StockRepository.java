package com.Inventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Inventory.Model.StockDetails;

@Repository
public interface StockRepository extends JpaRepository<StockDetails,Long>{

}
