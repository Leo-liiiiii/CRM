package com.ujiuye.pro.controller;

import com.ujiuye.pro.bean.Function;
import com.ujiuye.pro.service.FunctionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-07 21:13
 */
@Controller
@RequestMapping("/function")
public class FunctionController {
    @Resource
    private FunctionService functionService;

    @RequestMapping("showFunctions")
    @ResponseBody
    public List<Function>   showFunctions(){
            return  functionService.showFunctions();
    }

    @RequestMapping("saveInfo")
    public String saveInfo(Function function){
        boolean b = functionService.saveInfo(function);
        if (b){
            return "redirect:/project-function.jsp";

        }else{
            return "redirect:/error.jsp";
        }
    }


    @RequestMapping("getFuncByMid")
    @ResponseBody
    public List<Function>    getFuncByMid(int mid){
        return  functionService.getFuncByMid(mid);
    }

}
