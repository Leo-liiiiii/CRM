package com.ujiuye.pro.mapper;

import com.ujiuye.pro.bean.Project;

import java.util.List;

/**
 * @author 朱峰
 * @create 2020-07-02 16:39
 */
public interface ProjectMapper {

    //关联查询方法
    List<Project>  getAllproInfo();

      int insert(Project project);

      Project     selectByPrimaryKey(int id);

    List<Project> showNoAnalysisInfo();

    List<Project> showProHasAnalysis();

    List<Project> showProHasAsisAndModule();

  List<Project>  showProWithFunction();
}
