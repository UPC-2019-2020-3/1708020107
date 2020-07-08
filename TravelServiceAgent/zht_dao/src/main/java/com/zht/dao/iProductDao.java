package com.zht.dao;

import com.zht.domain.Guide;
import com.zht.domain.Hotel;
import com.zht.domain.Member;
import com.zht.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface iProductDao {

    //查询所有商品信息
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    @Insert("insert into product values(id,#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus},#{guideNum},#{hotelNum},'反馈：',#{peopleTotal},#{timeTotal})")
    void save(Product product) throws Exception;

    //根据id查产品
    @Select("select * from product where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "productNum", column = "productNum"),
            @Result(property = "productName", column = "productName"),
            @Result(property = "cityName", column = "cityName"),
            @Result(property = "departureTime", column = "departureTime"),
            @Result(property = "productPrice", column = "productPrice"),
            @Result(property = "productDesc", column = "productDesc"),
            @Result(property = "productStatus", column = "productStatus"),
            @Result(property = "peopleTotal", column = "peopleTotal"),
            @Result(property = "timeTotal", column = "timeTotal"),
            @Result(property = "hotelNum", column = "hotelNum"),
            @Result(property = "hotel",column = "hotelNum",javaType = Hotel.class,one = @One(select = "com.zht.dao.iHotelDao.findById")),
            @Result(property = "guide",column = "guideNum",javaType = Guide.class,one = @One(select = "com.zht.dao.iGuideDao.findById")),
    })
    public Product findById(int id) throws Exception;

    @Delete("delete from product where id=#{productId}")
    void deleteRoleById(int productId) throws Exception;

    @Delete("delete from product where id=#{productId}")
    void deleteProducts(@Param("productId") int productId) throws Exception;

    @Update("update product set productReturn = concat(productReturn,#{productReturn}) where id=(SELECT productId from orders where id = #{orderId});")
    void addReturn(@Param("orderId") int orderId,@Param("productReturn") String productReturn) throws Exception;

    @Update("update orders set writtenStatus = 1")
    void resetOrderStatus(@Param("orderId") int orderId) throws Exception;

    @Update("update product set productStatus = 1 where id=#{productId}")
    void openProductById(int productId) throws Exception;
}
