package com.ujiuye.usual.controller;

import com.ujiuye.usual.bean.Expendituretype;
import com.ujiuye.usual.service.ExpenditureTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**

 */
@Controller
@RequestMapping("/exp")
public class ExpenditureTypeController {

    @Resource
    private ExpenditureTypeService expenditureTypeService;

    @RequestMapping("showExp")
    @ResponseBody
    public List<Expendituretype> showExp(){

        return expenditureTypeService.showExp();

    }
}
