package com.ujiuye.usual.service;

import com.ujiuye.usual.bean.Notice;

import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-09 17:14
 */
public interface NoticeService {
    List<Notice> showAll();

    boolean saveinfo(Notice notice);

    List<Notice> showMainPage();

    Notice showOneInfo(int nid);
}
