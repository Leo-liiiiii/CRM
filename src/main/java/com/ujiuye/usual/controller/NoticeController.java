package com.ujiuye.usual.controller;

import com.ujiuye.usual.bean.Notice;
import com.ujiuye.usual.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-09 17:11
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {
@Resource
private NoticeService noticeService;

    @RequestMapping("showAll")
    @ResponseBody
    public List<Notice>  showAll(){
     return  noticeService.showAll();
    }


    @RequestMapping("saveinfo")
       public  String  saveinfo(Notice notice){
        notice.setNdate(new Date());
        //设置当前登录用户的id为通知公告的员工外键
        //notice.setEmpFk();
      boolean b=  noticeService.saveinfo(notice);
      if (b){
          return  "redirect:/notice.jsp";
      }else {
          return  "error.jsp";
      }
    }

    @RequestMapping("showMainPage")
    @ResponseBody
    public   List<Notice>   showMainPage(){

        return  noticeService.showMainPage();
    }


    @RequestMapping("showOneInfo")
    @ResponseBody
    public   Notice  showOneInfo(int  nid){
        return  noticeService.showOneInfo(nid);
    }
}
