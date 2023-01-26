package com.claurier.mychessgame.web.dao;


import com.claurier.mychessgame.web.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
}
