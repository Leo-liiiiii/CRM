package com.ujiuye.emp.service;

import com.ujiuye.emp.bean.Employee;

import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-01 21:30
 */
public interface EmployeeService {

    //查询项目经理
      List<Employee> showManagerInfo(int pFk) ;

    //登录方法，返回对象
    Employee login(String username,String pass);

    List<Employee> showEmp();

    List<Employee> showEmpAndArchives();

     List<Employee> showAllemp();
}
