package com.ujiuye.usual.service;

import com.ujiuye.usual.bean.Baoxiao;
import com.ujiuye.usual.bean.Baoxiaoreply;
import com.ujiuye.usual.mapper.BaoxiaoMapper;
import com.ujiuye.usual.mapper.BaoxiaoreplyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-09 22:25
 */
@Service
public class BaoXiaoServiceImpl  implements  BaoXiaoService {
    @Resource
    private BaoxiaoMapper baoxiaoMapper;

    @Resource
    private BaoxiaoreplyMapper baoxiaoreplyMapper;

    @Override
    public List<Baoxiao> getAllBaoxiao() {
        return baoxiaoMapper.getAllBaoxiao();
    }

    @Override
    public Baoxiao getOneBaoXiaoByid(String bxid) {
        return baoxiaoMapper.getOneBaoXiaoByid(bxid);
    }

    @Override
    public boolean shenpi(Baoxiao baoxiao, String content) {

        //改变报销状态   同意是为1   驳回是2 （1,2是由前端传来的bxstatus）由baoxiao对象直接接收
        boolean b = baoxiaoMapper.updateByPrimaryKeySelective(baoxiao)>0;

        //创建批注信息对象   新建一个批注
        Baoxiaoreply br = new Baoxiaoreply();
        br.setBaoxiaoFk(baoxiao.getBxid());
        br.setReplytime(new Date());

        br.setContent(content);
        boolean b1 = baoxiaoreplyMapper.insert(br)>0;
//两项都满足之后，才算成功
        if (b&&b1){
            return true;
        }
        return false;
    }

    @Override
    public List<Baoxiao> getBaoxiaoByEid() {
        //这个id自己加的，代表当前员工的id。实际开发中从redis获取
        List<Baoxiao> baoxiaos = baoxiaoMapper.getBaoxiaoByEid(1);
        return baoxiaos;
    }

    @Override
    public Baoxiao showBaoxiaoAndEx(String bxid) {
        return baoxiaoMapper.showBaoxiaoAndEx(bxid);
    }

    @Override
    public boolean updateBaoxiao(Baoxiao baoxiao) {
        return baoxiaoMapper.updateByPrimaryKeySelective(baoxiao)>0;
    }

    @Override
    public boolean saveInfo(Baoxiao baoxiao) {
        return baoxiaoMapper.insert(baoxiao)>0;
    }
}
