package com.ujiuye.cus.service;

import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.bean.CustomerVo;
import com.ujiuye.cus.mapper.CustomMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-01 22:05
 */
@Service
public class CustomerServiceImpl  implements  CustomerService{

@Resource
    CustomMapper customMapper;

    //根据id查询用户
    @Override
    public Customer getOneById(Integer id) {
        return customMapper.selectByPrimaryKey(id);
    }

    //查询用户
    @Override
    public List<Customer> pageList(CustomerVo vo) {
        return customMapper.pageList(vo);
    }
    //添加用户
    @Override
    public boolean saveCustomer(Customer customer) {
        return  customMapper.insert(customer) >0;
    }



//修改用户信息
    @Override
    public boolean updateInfo(Customer customer) {
        return  customMapper.updateByPrimaryKey(customer)>0;
    }

    @Override
    public boolean bachDelete(List<Integer> list) {
        return  customMapper.bachDelete(list)>0;
    }
}
