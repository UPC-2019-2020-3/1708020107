package com.zht.dao;

import com.zht.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface iProductDao {

    //查询所有商品信息
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    @Insert("insert into product values(id,#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    //根据id查产品
    @Select("select * from product where id=#{id}")
    public Product findById(String id) throws Exception;
}
