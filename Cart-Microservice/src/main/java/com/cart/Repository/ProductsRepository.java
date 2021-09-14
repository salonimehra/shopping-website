package com.cart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.Model.Products;


@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer>{

}
