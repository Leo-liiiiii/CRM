package com.ujiuye.usual.service;

import com.ujiuye.usual.bean.Expendituretype;
import com.ujiuye.usual.mapper.ExpendituretypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-10 18:25
 */
@Service
public class ExpenditureTypeServiceImpl  implements  ExpenditureTypeService{
    @Resource
    ExpendituretypeMapper expendituretypeMapper;

    @Override
    public List<Expendituretype> showExp() {
        return expendituretypeMapper.showExp();
    }
    }

