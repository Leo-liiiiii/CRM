package com.ujiuye.emp.controller;

import com.alibaba.druid.sql.ast.statement.SQLIfStatement;
import com.ujiuye.emp.bean.Employee;
import com.ujiuye.emp.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-01 21:37
 */
@Controller
@RequestMapping("emp")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

//    @Resource
//    private JedisPool jedisPool;

    @RequestMapping("showAllemp")
    @ResponseBody
    public  List<Employee> showAllemp(){
        return employeeService.showAllemp();
    }


    @RequestMapping("login")
    public String login(String name, String pass) {

        Employee login = employeeService.login(name, pass);
        System.out.println("我要登录了");
        if (login != null) {
                return "redirect:/index.jsp";
//            Jedis resource = jedisPool.getResource();
//            resource.set(, );

        } else {
            return "redirect:/login.jsp";
        }
    }

    @RequestMapping("logout")
    public String logout() {
//        Jedis resource = jedisPool.getResource();
//        resource.del();
        return "redirect:/login.jsp";
        }
@RequestMapping("showManagerInfo")
@ResponseBody
        public List<Employee>  showManagerInfo(int  pFk){
        return  employeeService.showManagerInfo(pFk);
        }


    @RequestMapping("showEmp")
    @ResponseBody
    public List<Employee>  showEmp(){

        return  employeeService.showEmp();
    }

    @RequestMapping("showEmpAndArchives")
    @ResponseBody
    public List<Employee> showEmpAndArchives(){
        return employeeService.showEmpAndArchives();
    }




}


