package com.zht.service;

import com.zht.domain.Role;
import com.zht.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;

public interface iUserService extends UserDetailsService {

    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(int userId) throws Exception;

    List<Role> findOtherRoles(int userId) throws Exception;

    void addRoleToUser(int userId, int[] roleIds) throws Exception;

    void deleteUser(int userId) throws Exception;
}
