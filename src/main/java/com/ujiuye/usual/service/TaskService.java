package com.ujiuye.usual.service;

import com.ujiuye.usual.bean.Task;

import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-08 21:15
 */
public interface TaskService {
    boolean addInfo(Task task);

    List<Task> showTask(int eid);

    List<Task> showMyTask(int eid);

    boolean updateTaskStatus(Task task);
}
