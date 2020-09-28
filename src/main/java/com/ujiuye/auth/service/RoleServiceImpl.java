package com.ujiuye.auth.service;

import com.ujiuye.auth.bean.RoleSources;
import com.ujiuye.auth.mapper.RoleMapper;
import com.ujiuye.auth.mapper.RoleSourcesMapper;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-13 21:05
 */
@Service
public class RoleServiceImpl  implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleSourcesMapper roleSourcesMapper;



    @Override
    public boolean addRole(com.ujiuye.auth.bean.Role role, String sourcesid) {
        //角色添加
        //role id 获取：MyBatis主键返回值 selectKey
        int i = roleMapper.insert(role);
        if (i>0){
            String[] sourcesids = sourcesid.split(",");
            //角色资源中间表
            List<RoleSources> list = new ArrayList<>();
            for (int j=0;j<sourcesids.length;j++){
                RoleSources roleSources = new RoleSources();
                roleSources.setRoleid(role.getRoleid());
                roleSources.setSid(Integer.parseInt(sourcesids[j]));
                roleSources.setRsdis(role.getRoledis()+"有"+Integer.parseInt(sourcesids[j])+"的权限");
                System.out.println(roleSources.getRsdis());
                list.add(roleSources);
            }
            //批量添加角色权限中间表的数据
            int k = roleSourcesMapper.batchInsert(list);

            if (k>0){
                return true;
            }
        }
        return false;
    }
}
