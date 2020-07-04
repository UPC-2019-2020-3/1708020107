package com.zht.service;

import com.zht.domain.Permission;

import java.util.List;

public interface iPermissionService {

    public List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    void deletePermissionById(int permissionId) throws Exception;
}
