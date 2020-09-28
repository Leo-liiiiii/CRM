package com.ujiuye.pro.mapper;

import com.ujiuye.pro.bean.Function;

import java.util.List;

/**
 * @author 朱峰
 * @create 2020-07-02 16:39
 */
public interface FunctionMapper {
    List<Function> showFunctions();

    int insert(Function function);

    List<Function> getFuncByMid(int mid);
}
