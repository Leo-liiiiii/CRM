package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Project;

import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-06 13:24
 */
public interface ProjectService {

    List<Project> showNoAnalysisInfo();

    List<Project> showAllProInfo();

    boolean savepro(Project project);

    List<Project> showProHasAnalysis();

    List<Project> showProHasAsisAndModule();

    List<Project> showProWithFunction();
}
