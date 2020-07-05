package com.zht.service;

import com.zht.domain.Product;

import java.util.List;

public interface iProductService {

    public List<Product> findAll() throws Exception;

    void save(Product product)throws Exception;

    void deleteProductById(int productId) throws Exception;

    void deleteProducts(int[] productIds) throws Exception;
}
