package com.ujiuye.pro.controller;

import com.ujiuye.pro.bean.Module;
import com.ujiuye.pro.service.ModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-07 13:03
 */
@Controller
@RequestMapping("/module")
public class ModuleController {

@Resource
private  ModuleService moduleService;

//查全部
    @RequestMapping("showAllModule")
    @ResponseBody
    public List<Module>  showAllModule(){
   List<Module>  modules=moduleService.showAllModule();
      return modules;
    }


    @RequestMapping("saveInfo")
    public String saveInfo(Module module){
        boolean b = moduleService.saveInfo(module);
        if (b){
            return "redirect:/project-model.jsp";
        }else {
            return "error";
        }
    }
}
