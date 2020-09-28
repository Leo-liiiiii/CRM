package com.ujiuye.auth.controller;

import com.ujiuye.auth.bean.Role;
import com.ujiuye.auth.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * @author LiLe
 * @create 2020-07-13 20:56
 */
@Controller
@RequestMapping("/role")
public class RoleController {
@Resource
private RoleService roleService;
    @RequestMapping(value = "addRole",method = RequestMethod.POST)
public  String   addRole(Role role,String sourcesid){
        boolean b = roleService.addRole(role,sourcesid);
        if (b){
            return "redirect:/role.jsp";
        }else {
            return "redirect:/error.jsp";
        }
    }
}
