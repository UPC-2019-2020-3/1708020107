package com.zht.dao;

import com.zht.domain.Product;

import java.util.List;

public interface iProductDao {

    //查询所有商品信息
    public List<Product> findAll() throws Exception;
}
