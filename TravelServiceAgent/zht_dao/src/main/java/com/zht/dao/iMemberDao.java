package com.zht.dao;

import com.zht.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface iMemberDao {

    @Select("select * from member where id = #{id}")
    public Member findById(String id) throws Exception;

}
