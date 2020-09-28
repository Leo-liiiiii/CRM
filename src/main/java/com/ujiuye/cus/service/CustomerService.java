package com.ujiuye.cus.service;

import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.bean.CustomerVo;

import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-01 22:05
 */
public interface CustomerService {
    //处理添加用户
    boolean saveCustomer(Customer customer);
    //查询全部用户
    List<Customer>  pageList(CustomerVo vo);

      Customer   getOneById( Integer id);

      boolean updateInfo(Customer customer);

      boolean bachDelete(List<Integer> list) ;
}
