package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Analysis;
import com.ujiuye.pro.bean.Module;
import com.ujiuye.pro.mapper.AnalysisMapper;
import com.ujiuye.pro.mapper.ModuleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-06 22:38
 */
@Service
public class AnalysisServiceImpl implements AnalysisService {
    @Resource
    private AnalysisMapper analysisMapper;
    @Resource
      private   ModuleMapper moduleMapper;



    @Override
    public List<Analysis> showAllInfo() {
        return analysisMapper.showAllInfo();
    }

    @Override
    public boolean saveAnalysis(Analysis analysis) {
        return analysisMapper.insert(analysis)>0;
    }

    @Override
    public Analysis getAnaInfo(int pid) {
           //缺少一个model集合
        Analysis analysis=analysisMapper.selectByPrimaryKey1(pid);
        //单独查询module复制给analysis
         List<Module>  modules=moduleMapper.selectByAnFK(pid);
         analysis.setModules(modules);
        return analysis;
    }
}
