package com.ujiuye.pro.controller;

import com.ujiuye.pro.bean.Project;
import com.ujiuye.pro.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-06 13:21
 */
@Controller
@RequestMapping("pro")
public class ProjectController {
    @Resource
    private ProjectService projectService;

    @RequestMapping("showAllProInfo")
    @ResponseBody
  public List<Project>  showAllProInfo(){
        return   projectService.showAllProInfo();
    }


@RequestMapping(value = "savePro",method = RequestMethod.POST)
  public    String   savePro(Project project,String newcomname){
        //把接收到的公司id传进去，接收前端的字符串，进行截取

       project.setComname(Integer.parseInt(newcomname.split(",")[0]));
        boolean b=projectService.savepro(project );
        return "project-base";
}
@RequestMapping("showNoAnalysisInfo")
@ResponseBody
    public  List<Project>  showNoAnalysisInfo(){
        return  projectService. showNoAnalysisInfo();
}

    @RequestMapping("showProHasAnalysis")
    @ResponseBody
    public List<Project> showProHasAnalysis(){
        return projectService.showProHasAnalysis();
    }

    @RequestMapping("showProHasAsisAndModule")
    @ResponseBody
    public  List<Project>  showProHasAsisAndModule(){
          return  projectService.showProHasAsisAndModule();
    };

    @RequestMapping("showProWithFunction")
    @ResponseBody
    public  List<Project>  showProWithFunction(){
        return  projectService.showProWithFunction();
    };
}
