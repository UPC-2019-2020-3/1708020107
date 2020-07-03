package com.zht.dao;

import com.zht.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface iPermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(int id) throws Exception;

}
