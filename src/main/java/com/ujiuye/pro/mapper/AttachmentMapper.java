package com.ujiuye.pro.mapper;

import com.ujiuye.pro.bean.Attachment;

import java.util.List;

/**
 * @author 朱峰
 * @create 2020-07-02 16:39
 */
public interface AttachmentMapper {
          List<Attachment> showAllInfo();

    int  insert(Attachment attachment);

    Attachment selectByPrimaryKey(int id);
}
