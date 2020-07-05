package com.zht.dao;

import com.zht.domain.Member;
import com.zht.domain.Orders;
import com.zht.domain.Product;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public interface iOrdersDao {

    //单表
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "auditStatus", column = "auditStatus"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.zht.dao.iProductDao.findById")),
    })
    List<Orders> findAll(int pageNum, int pageSize) throws Exception;

    List<Orders> findAllOrders() throws Exception;

    //多表
    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "auditStatus", column = "auditStatus"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.zht.dao.iProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.zht.dao.iMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType =java.util.List.class,many = @Many(select = "com.zht.dao.iTravellerDao.findByOrdersId"))
    })
    public Orders findById(int ordersId) throws Exception;

    @Insert("insert into orders(orderNum,peopleCount,orderDesc,productId) values(#{orderNum},#{peopleCount},#{orderDesc},#{productId})")
    void save(Orders orders) throws Exception;
}
