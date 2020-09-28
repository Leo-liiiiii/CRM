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

public interface ModuleService {


      List<Module> showAllModule();

    boolean saveInfo(Module module);
}
