package com.ujiuye.cus.mapper;

import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.bean.CustomerVo;

import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-01 22:01
 */
public interface CustomMapper {


     //添加用户
     int   insert(Customer customer);
//查询方法
     List<Customer> pageList(CustomerVo vo);
     //根据id查询
     Customer selectByPrimaryKey(Integer id);

     int updateByPrimaryKey(Customer customer);
//批量删除方法
     int bachDelete(List<Integer> list);
}
