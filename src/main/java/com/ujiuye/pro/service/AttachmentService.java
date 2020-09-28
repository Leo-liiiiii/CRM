package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Attachment;

import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-08 10:47
 */
public interface AttachmentService {
         List<Attachment>   showAllInfo();

    boolean saveInfo(Attachment attachment);

    Attachment selectByPrimaryKey(int id);
}
