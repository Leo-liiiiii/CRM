package com.ujiuye.usual.mapper;


import com.ujiuye.usual.bean.Archives;

public interface ArchivesMapper {
    int deleteByPrimaryKey(String dnum);

    int insert(Archives record);

    int insertSelective(Archives record);

    Archives selectByPrimaryKey(String dnum);

    int updateByPrimaryKeySelective(Archives record);

    int updateByPrimaryKey(Archives record);

    Archives selectByEid(int eid);
}