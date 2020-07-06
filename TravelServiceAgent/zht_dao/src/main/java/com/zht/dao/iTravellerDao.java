package com.zht.dao;

import com.zht.domain.Product;
import com.zht.domain.Traveller;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface iTravellerDao {

    @Select("select * from traveller")
    public List<Traveller> findAll() throws Exception;

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOrdersId(int ordersId) throws Exception;

    @Insert("insert into traveller (id,name, sex,phoneNum,credentialsType,credentialsNum,travellerType,emailadd) values(id,#{name},#{sex},#{phoneNum},#{credentialsType},#{credentialsNum},#{travellerType},#{emailadd})")
    void save(Traveller traveller);

    @Delete("delete from traveller where id=#{travellerId}")
    void deleteTravellerById(int travellerId) throws Exception;
}
