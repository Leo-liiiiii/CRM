package com.ujiuye.usual.controller;

import com.ujiuye.usual.bean.Task;
import com.ujiuye.usual.service.TaskService;
import com.ujiuye.util.ResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-08 21:14
 */
@Controller
@RequestMapping("/task")
public class TaskController {
    @Resource
    private TaskService taskService;

    @RequestMapping("addInfo")
    public String addInfo(Task task) {
        boolean b = taskService.addInfo(task);
        if (b) {
            return "redirect:/task.jsp";
        } else {
            return "redirect:/error.jsp";
        }

    }
    @RequestMapping("showTask")
    @ResponseBody
    public List<Task> showTask(){
        //Jedis获取id
        return taskService.showTask(1);
    }

    @RequestMapping("showMyTask")
    @ResponseBody
    public List<Task>     showMyTask(){
        //jedis获取当前用户的id
        return  taskService.showMyTask(5);

    }
    @RequestMapping("updateTaskStatus")
@ResponseBody
    public ResultInfo     updateTaskStatus(Task task){
       boolean b= taskService. updateTaskStatus( task);
        ResultInfo resultInfo = new ResultInfo();
        if (b){
            resultInfo.setFlag(b);
        }
            return  resultInfo;

    }



}
