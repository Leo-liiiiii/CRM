package com.ujiuye.auth.mapper;


import com.ujiuye.auth.bean.Sources;

import java.util.List;

public interface SourcesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sources record);

    int insertSelective(Sources record);

    Sources selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sources record);

    int updateByPrimaryKey(Sources record);

    Sources getRootSources();

    List<Sources> getChild(Integer id);
}