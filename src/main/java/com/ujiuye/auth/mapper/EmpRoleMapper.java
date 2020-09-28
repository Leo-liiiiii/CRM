package com.ujiuye.auth.mapper;


import com.ujiuye.auth.bean.EmpRole;

public interface EmpRoleMapper {
    int deleteByPrimaryKey(Integer erid);

    int insert(EmpRole record);

    int insertSelective(EmpRole record);

    EmpRole selectByPrimaryKey(Integer erid);

    int updateByPrimaryKeySelective(EmpRole record);

    int updateByPrimaryKey(EmpRole record);
}