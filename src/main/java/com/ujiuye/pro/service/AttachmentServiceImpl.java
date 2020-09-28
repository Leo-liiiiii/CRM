package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Attachment;
import com.ujiuye.pro.mapper.AttachmentMapper;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-08 10:47
 */

@Service
public class AttachmentServiceImpl  implements  AttachmentService{
    @Resource
    private AttachmentMapper attachmentMapper;
    @Resource
    private JedisPool jedisPool;

    @Override
    public List<Attachment> showAllInfo() {
        List<Attachment>  attachments= attachmentMapper.showAllInfo();
        //缓存下载地址  id作为key   path作为value缓存
//        if (attachments.size()>0){
//            Jedis jedis = jedisPool.getResource();
//            for (Attachment attachment : attachments) {
//                jedis.set(attachment.getId()+"", attachment.getPath());
//            }
//            jedis.close();
//        }
        return attachments;
    }

    @Override
    public boolean saveInfo(Attachment attachment) {
        return attachmentMapper.insert(attachment)>0;
    }

    @Override
    public Attachment selectByPrimaryKey(int id) {
        return attachmentMapper.selectByPrimaryKey(id);
    }


}
