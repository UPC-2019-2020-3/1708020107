package com.zht.service.impl;

import com.zht.dao.iPermissionDao;
import com.zht.domain.Permission;
import com.zht.service.iPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceimpl implements iPermissionService {

    @Autowired
    private iPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception{
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception{
        // 不好的设计
        Integer permissionId = (int) (Math.random() * Math.random() * Math.random() * 100000);
        permission.setId(permissionId.toString());
        permissionDao.save(permission);
    }

    @Override
    public void deletePermissionById(int id) throws Exception {
        permissionDao.deleteFromRole_Permission(id);
        permissionDao.deleteById(id);
    }
}
