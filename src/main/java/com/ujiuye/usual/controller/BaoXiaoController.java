package com.ujiuye.usual.controller;

import com.ujiuye.usual.bean.Baoxiao;
import com.ujiuye.usual.service.BaoXiaoService;
import com.ujiuye.util.ResultInfo;
import com.ujiuye.util.UuidUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author LiLe
 * @create 2020-07-09 22:25
 */
@Controller
@RequestMapping("/baoxiao")
public class BaoXiaoController {
    @Resource
    private BaoXiaoService baoXiaoService;
@RequestMapping("getAllBaoxiao")
@ResponseBody
    public List<Baoxiao>      getAllBaoxiao(){
     List<Baoxiao>  baoxiaos=baoXiaoService. getAllBaoxiao();
     return  baoxiaos;
    }

    @RequestMapping("getOneBaoXiaoByid")
    @ResponseBody
    public Baoxiao getOneBaoXiaoByid(String bxid){
        Baoxiao baoxiao = baoXiaoService.getOneBaoXiaoByid(bxid);
        return baoxiao;
    }

    @RequestMapping("shenpi")
    @ResponseBody
    public ResultInfo shenpi(Baoxiao baoxiao, String content){

        boolean b = baoXiaoService.shenpi(baoxiao,content);
        ResultInfo resultInfo = new ResultInfo();
        if (b){
            resultInfo.setFlag(true);
        }
        return resultInfo;
    }

    @RequestMapping("getBaoxiaoByEid")
    @ResponseBody
    public List<Baoxiao> getBaoxiaoByEid(){
        return baoXiaoService.getBaoxiaoByEid();
    }

    @RequestMapping("showBaoxiaoAndEx")
    @ResponseBody
    public  Baoxiao    showBaoxiaoAndEx(String bxid){

    return baoXiaoService.showBaoxiaoAndEx(bxid);

    }


    @RequestMapping("updateBaoxiao")
    public String updateBaoxiao(Baoxiao baoxiao){
        //修改报销状态  (驳回的和未审批的都修改为未审批状态)
        baoxiao.setBxstatus(0);
        boolean b = baoXiaoService.updateBaoxiao(baoxiao);

        if (b){
            return "redirect:/mybaoxiao-base.jsp";
        }else {
            return "error";
        }
    }


    @RequestMapping("saveInfo")
    public String saveInfo(Baoxiao baoxiao){

        //设置报销人，从redis获取信息
        baoxiao.setEmpFk(1);
        //设置报销编号
        baoxiao.setBxid(UuidUtil.getUUID());
        //设置报销状态
        baoxiao.setBxstatus(0);

        boolean b = baoXiaoService.saveInfo(baoxiao);
        if (b){
            return "redirect:/mybaoxiao-base.jsp";
        }else {
            return "error";
        }

    }


}
