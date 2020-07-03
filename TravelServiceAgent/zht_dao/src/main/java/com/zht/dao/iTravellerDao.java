package com.zht.dao;

import com.zht.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface iTravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOrdersId(int ordersId) throws Exception;

}
