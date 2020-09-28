package com.ujiuye.usual.service;

import com.ujiuye.usual.bean.Task;
import com.ujiuye.usual.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-08 21:16
 */
@Service
public class TaskServiceImpl  implements  TaskService{
    @Resource
    private TaskMapper taskMapper;
    @Override
    public boolean addInfo(Task task) {
        //获取员工json   Gson 转成对象
        //task.setEmpFk(emp.getEmpFK)
        //设置任务发布的员工
        task.setEmpFk(1);
        //设置任务的状态
        task.setStatus(0);
        return taskMapper.insert(task)>0;
    }

    @Override
    public List<Task> showTask(int eid) {
        return taskMapper.showTask(eid);
    }


    @Override
    public List<Task> showMyTask(int eid) {
        return taskMapper.showMyTask(eid);
    }

    @Override
    public boolean updateTaskStatus(Task task) {
        return taskMapper.updateByPrimaryKeySelective(task)>0;
    }
}
