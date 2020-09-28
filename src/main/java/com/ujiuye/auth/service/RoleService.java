package com.ujiuye.auth.service;

import com.ujiuye.auth.bean.Role;

/**
 * @author LiLe
 * @create 2020-07-13 21:04
 */
public interface RoleService {
    boolean addRole(Role role, String sourcesid);
}
