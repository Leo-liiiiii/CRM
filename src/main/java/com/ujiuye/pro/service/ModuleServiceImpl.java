package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Module;
import com.ujiuye.pro.mapper.ModuleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-07 13:07
 */
@Service
public class ModuleServiceImpl  implements  ModuleService{
    @Resource
    private ModuleMapper moduleMapper;

    @Override
    public List<Module> showAllModule() {
        return  moduleMapper.showAllModule();
    }

    @Override
    public boolean saveInfo(Module module) {
        return moduleMapper.insert(module)>0;
    }
}
