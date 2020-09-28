package com.ujiuye.usual.service;

import com.ujiuye.usual.bean.Baoxiao;

import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-09 22:26
 */
public interface BaoXiaoService {
    List<Baoxiao> getAllBaoxiao();

    Baoxiao getOneBaoXiaoByid(String bxid);

    boolean shenpi(Baoxiao baoxiao, String content);

    List<Baoxiao> getBaoxiaoByEid();

    Baoxiao showBaoxiaoAndEx(String bxid);

    boolean updateBaoxiao(Baoxiao baoxiao);

    boolean saveInfo(Baoxiao baoxiao);
}
