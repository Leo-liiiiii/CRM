package com.ujiuye.emp.mapper;


import com.ujiuye.emp.bean.Level;

public interface LevelMapper {
    int deleteByPrimaryKey(Integer jid);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByPrimaryKey(Integer jid);

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKey(Level record);
}