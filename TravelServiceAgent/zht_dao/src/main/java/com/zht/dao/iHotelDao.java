package com.zht.dao;

import com.zht.domain.Hotel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface iHotelDao {

    @Select("select * from hotel")
    List<Hotel> findAll() throws Exception;

    @Select("select * from hotel where id = #{id}")
    public Hotel findById(int id) throws Exception;

}
