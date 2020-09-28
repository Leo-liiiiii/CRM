package com.ujiuye.cus.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.bean.CustomerVo;
import com.ujiuye.cus.service.CustomerService;
import com.ujiuye.util.ResultInfo;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;
import java.net.SocketOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-01 22:04
 */
@Controller
@RequestMapping("/cus")
public class CustomerController {

  @Resource
    CustomerService customerService;
    @RequestMapping("saveCustomer")
    public  String saveCustomer(Customer customer){
        customer.setAddtime(new Date());
    boolean b = customerService.saveCustomer(customer);
    if(b){
        return  "redirect:/customer.jsp";
    }else {
        return "error";
    }
    }
    //分页查询方法
    @RequestMapping("showInfo")
    @ResponseBody
    public     PageInfo<Customer>  showInfo(@RequestParam(value =  "currentpage") Integer pageNum, CustomerVo vo){
        //开启分页
        //分页+排序时需要在开启分页时传入排序参数

        if(vo.getNum()==1){
            //开启分页，带排序
            //要求pageHelper 5.0以上版本
            //需要导入<artifactId>jsqlparser</artifactId>
            String orderBy="id desc";
            PageHelper.startPage(pageNum, 2,orderBy);
        }else {
            //不需要排序
            PageHelper.startPage(pageNum, 2);
        }
        //获取数据源
        List<Customer> customers = customerService.pageList(vo);
        System.out.println("+++++++++++++++++++++++++++++++++==================="+vo);

        //分页处理数据源
        PageInfo<Customer>  PageInfo = new PageInfo<>(customers);
        return PageInfo;
    }

//查看一个用户的详细信息（查看详情）
    @RequestMapping("getOneInfo")
    @ResponseBody
    public  Customer  getOneInfo( Integer id){

        return  customerService.getOneById(id);
    }

//更新数据操作(需要查看详情方法首先实现，因为一点击修改跳转页面，根据id发送ajax请求回显数据)
    @RequestMapping("updateInfo")
    public  String  updateInfo(Customer customer){
    customer.setAddtime(new Date());
    boolean b=customerService.updateInfo(customer);
    if (b){
        return  "customer";
    }else {
        return  "error";
    }
    }

    //批量删除的方法
    @RequestMapping("bachDelete")
    @ResponseBody
public ResultInfo bachDelete(String ids){
        //list集合是执行批量删除的条件
     List<Integer> list = new ArrayList<>();
     for(String id:ids.split(",")){
         list.add(Integer.parseInt(id));
     }
     //service执行删除
   boolean b= customerService.bachDelete(list);
        ResultInfo ri = new ResultInfo();
        if (b){
         ri.setFlag(true);
     }
        return ri;
}
//
    @RequestMapping("showAllInfo")
    @ResponseBody
    public  List<Customer>  showAllInfo(){

        return  customerService.pageList(null);
    }

}
