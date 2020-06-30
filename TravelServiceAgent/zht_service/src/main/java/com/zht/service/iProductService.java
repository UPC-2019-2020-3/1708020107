package com.zht.service;

import com.zht.domain.Product;

import java.util.List;

public interface iProductService {

    public List<Product> findAll() throws Exception;

}
