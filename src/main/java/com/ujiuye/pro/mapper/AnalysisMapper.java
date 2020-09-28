package com.ujiuye.pro.mapper;

import com.ujiuye.pro.bean.Analysis;

import java.util.List;

/**
 * @author 朱峰
 * @create 2020-07-02 16:39
 */
public interface AnalysisMapper {
       List<Analysis> showAllInfo();

        int insert(Analysis analysis);

        Analysis  selectByPrimaryKey1(int id);


}
