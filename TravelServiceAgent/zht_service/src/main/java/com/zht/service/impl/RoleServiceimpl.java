package com.zht.service.impl;

import com.zht.dao.iRoleDao;
import com.zht.domain.Permission;
import com.zht.domain.Role;
import com.zht.service.iRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceimpl implements iRoleService {

    @Autowired
    private iRoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(int roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public void deleteRoleById(int roleId) throws Exception {
        roleDao.deleteRoleById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(int roleId) throws Exception {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void addPermissionToRole(int roleId, int[] permissionIds) {
        for(int permissionId:permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }


}
