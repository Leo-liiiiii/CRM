package com.ujiuye.pro.mapper;

import com.ujiuye.pro.bean.Module;

import java.util.List;

/**
 * @author 朱峰
 * @create 2020-07-02 16:39
 */
public interface ModuleMapper {
    List<Module> showAllModule();

    int insert(Module module);

    Module  selectByPrimaryKey1(int id);

     List<Module>  selectByAnFK(int anid);
}
