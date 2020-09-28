package com.ujiuye.auth.service;

import com.ujiuye.auth.bean.Sources;
import com.ujiuye.auth.mapper.SourcesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 朱峰
 * @create 2020-07-13 10:54
 */
@Service
public class SourcesServiceImpl implements SourcesService {
    @Resource
    SourcesMapper sourcesMapper;


    @Override
    public Sources getRootSources() {
        //根目录
        Sources sources = sourcesMapper.getRootSources();

        sources.setOpen(true);

        return getChild(sources);
    }



    //递归查询所有的子节点
    public Sources getChild(Sources sources){
        //根据父节点id查询子节点
        List<Sources> child = sourcesMapper.getChild(sources.getId());
        //判断子节点是否为空
        if (child!=null&&child.size()>0){
            //子节点不为空，将子节点设置给父节点
            sources.setChildren(child);
            //对当前子节点下的子节点进行遍历
            for (int i=0;i<child.size();i++){
                Sources sources1 = child.get(i);
                //递归查询子节点下的子节点
                getChild(sources1);
            }
        }
        return sources;
    }
    @Override
    public boolean addSources(Sources sources) {
        return sourcesMapper.insertSelective(sources)>0;
    }
}
