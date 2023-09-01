package com.kareem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kareem.Entity.Product;

public interface ProductRepositroy extends JpaRepository<Product, Integer> {

}
 