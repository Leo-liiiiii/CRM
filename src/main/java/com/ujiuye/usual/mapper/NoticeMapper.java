package com.ujiuye.usual.mapper;


import com.ujiuye.usual.bean.Notice;

import java.util.List;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer nid);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer nid);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    List<Notice> showAll();

    List<Notice> showMainPage();


}