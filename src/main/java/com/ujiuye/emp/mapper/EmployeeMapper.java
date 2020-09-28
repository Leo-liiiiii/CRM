package com.ujiuye.emp.mapper;

import com.ujiuye.emp.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-01 21:18
 */
public interface EmployeeMapper {

    //主键查询
    Employee   selectByPrimaryKey(int eid);

    //登录方法
      Employee  login(@Param("name") String name, @Param("pass") String pass);
      //显示项目经理
      List<Employee> showPM(int pFk);

       List<Employee> showEmp();

       List<Employee>  showEmpAndArchives();

         List<Employee> showAllemp();
}
