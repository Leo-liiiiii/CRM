package com.ujiuye.usual.service;

import com.ujiuye.usual.bean.Notice;
import com.ujiuye.usual.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-09 17:14
 */
@Service
public class NoticeServiceImpl  implements  NoticeService {
    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> showAll() {
        return noticeMapper.showAll();
    }

    @Override
    public boolean saveinfo(Notice notice) {
        return noticeMapper.insert(notice)>0;
    }

    @Override
    public List<Notice> showMainPage() {
        return noticeMapper.showMainPage();
    }

    @Override
    public Notice showOneInfo(int nid) {
        return noticeMapper.selectByPrimaryKey(nid);
    }
}
