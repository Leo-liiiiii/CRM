package com.ujiuye.usual.mapper;


import com.ujiuye.usual.bean.Baoxiao;

import java.util.List;

public interface BaoxiaoMapper {
    int deleteByPrimaryKey(String bxid);

    int insert(Baoxiao record);

    int insertSelective(Baoxiao record);

    Baoxiao selectByPrimaryKey(String bxid);

    int updateByPrimaryKeySelective(Baoxiao record);

    int updateByPrimaryKey(Baoxiao record);

    List<Baoxiao> getAllBaoxiao();

    Baoxiao getOneBaoXiaoByid(String bxid);

    List<Baoxiao> getBaoxiaoByEid(int eid);

    Baoxiao showBaoxiaoAndEx(String bxid);
}