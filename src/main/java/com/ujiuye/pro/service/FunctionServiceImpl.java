package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Function;
import com.ujiuye.pro.mapper.FunctionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-07 21:16
 */
@Service
public class FunctionServiceImpl  implements  FunctionService{
    @Resource
    private FunctionMapper  functionMapper;

    @Override
    public List<Function> showFunctions() {
        return functionMapper.showFunctions();
    }

    @Override
    public boolean saveInfo(Function function) {
        return  functionMapper.insert(function)>0;
    }

    @Override
    public List<Function> getFuncByMid(int mid) {
        return functionMapper.getFuncByMid(mid);
    }
}
