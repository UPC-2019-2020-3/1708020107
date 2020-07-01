package com.zht.dao;

import com.zht.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface iProductDao {

    //查询所有商品信息
    @Select("select * from product")
    public List<Product> findAll() throws Exception;
}
