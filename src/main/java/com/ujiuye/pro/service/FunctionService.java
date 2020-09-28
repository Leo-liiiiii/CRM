package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Function;

import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-07 21:15
 */
public interface FunctionService {
    List<Function> showFunctions();

    boolean saveInfo(Function function);

    List<Function> getFuncByMid(int mid);
}
