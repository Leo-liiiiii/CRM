package com.ujiuye.auth.controller;

import com.ujiuye.auth.bean.Sources;
import com.ujiuye.auth.service.SourcesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 朱峰
 * @create 2020-07-13 10:50
 */
@Controller
@RequestMapping("/auth")
public class SourcesController {
    @Resource
    SourcesService sourcesService;
    //异步加载tree
    @RequestMapping("getRootSources")
    @ResponseBody
    public Sources getRootSources(){
        Sources rootSources = sourcesService.getRootSources();
        System.out.println(rootSources.getName());
        for (Sources sources:rootSources.getChildren()){
            System.out.println(sources.getName());
        }
        return rootSources;
    }

    @RequestMapping("addSources")
    public String addSources(Sources sources){
        boolean b = sourcesService.addSources(sources);
        if (b){
            return "redirect:/pm.jsp";
        }else {
            return "redirect:/error.jsp";
        }
    }
}
