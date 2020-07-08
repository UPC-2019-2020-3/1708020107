package com.zht.dao;

import com.zht.domain.Guide;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface iGuideDao {

    @Select("select * from guide")
    List<Guide> findAll() throws Exception;

    @Select("select * from guide where id = #{id}")
    public Guide findById(int id) throws Exception;
}
