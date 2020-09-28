package com.ujiuye.emp.service;

import com.ujiuye.emp.bean.Employee;
import com.ujiuye.emp.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-01 21:32
 */
@Service
public class EmployeeServiceImpl implements  EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> showManagerInfo(int pFk) {
        return employeeMapper.showPM(pFk);
    }

    @Override
    public Employee login(String username, String pass) {

           return employeeMapper. login(username, pass);
    }

    @Override
    public List<Employee> showEmp() {
        return employeeMapper.showEmp();
    }

    @Override
    public List<Employee> showEmpAndArchives() {
        return employeeMapper.showEmpAndArchives();
    }

    @Override
    public List<Employee> showAllemp() {
        return  employeeMapper.showAllemp();
    }
}
