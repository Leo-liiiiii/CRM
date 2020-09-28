package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Analysis;

import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-06 22:37
 */
public interface AnalysisService {
         List<Analysis>  showAllInfo();

       boolean saveAnalysis(Analysis analysis);

          Analysis getAnaInfo(int pid);
}
