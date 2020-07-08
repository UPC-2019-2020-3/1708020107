package com.zht.dao;

import com.zht.domain.Member;
import com.zht.domain.Orders;
import com.zht.domain.Product;
import com.zht.domain.Traveller;
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
            @Result(property = "finalStatus", column = "finalStatus"),
            @Result(property = "startCity", column = "startCity"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.zht.dao.iProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.zht.dao.iMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType =java.util.List.class,many = @Many(select = "com.zht.dao.iTravellerDao.findByOrdersId"))
    })
    public Orders findById(int ordersId) throws Exception;

    @Insert("insert into orders(orderNum,peopleCount,orderDesc,productId,memberId,auditStatus,orderStatus,payType,startcity) values(#{orderNum},#{peopleCount},#{orderDesc},#{productId},'1','0','1',#{payType},#{startCity})")
    void save(Orders orders) throws Exception;

    @Update("update orders set orderPrice = #{peopleCount}*(SELECT productPrice from product where id = #{productId}) WHERE orderNum=#{orderNum}")
    void saveprice(Orders orders) throws Exception;

    @Select("select * from traveller where id not in (select travellerId from order_traveller where orderId=#{ordersId})")
    List<Traveller> findOtherTravellers(int ordersId);

    @Insert("insert into order_traveller(orderId,travellerId) values(#{ordersId},#{travellerId})")
    void addTraveller(@Param("ordersId") int ordersId, @Param("travellerId") int travellerId) throws Exception;

    @Update("update orders set auditstatus = 1 where id = #{ordersId}")
    void auditOrder(@Param("ordersId") int ordersId) throws Exception;

    @Update("update orders set orderstatus = 2,paytype = 3 where id = #{ordersId}")
    void closeOrderStatus(@Param("ordersId")int ordersId) throws Exception;

    @Update("update orders set auditstatus = 2 where id = #{ordersId}")
    void closeOrderAudit(@Param("ordersId")int ordersId) throws Exception;

    @Update("update orders set finalstatus = 3 where id = #{ordersId}")
    void closeOrderFinal(@Param("ordersId")int ordersId) throws Exception;

}
