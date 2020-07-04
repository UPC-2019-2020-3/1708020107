package com.zht.service;

import com.zht.domain.Role;

import java.util.List;

public interface iRoleService {

    public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(int roleId) throws Exception;

    void deleteRoleById(int roleId) throws Exception;
}
