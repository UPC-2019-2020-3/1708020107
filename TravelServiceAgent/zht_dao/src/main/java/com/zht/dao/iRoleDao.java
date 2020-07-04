package com.zht.dao;

import com.zht.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface iRoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.zht.dao.iPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(int userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role values(id,#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    @Select("select * from role where id=#{roleId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.zht.dao.iPermissionDao.findPermissionByRoleId"))})
    Role findById(int roleId) throws Exception;

    @Delete("delete from role where id=#{roleId}")
    void deleteRoleById(int roleId) throws Exception;
}
