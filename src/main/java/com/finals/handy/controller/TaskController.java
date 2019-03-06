package com.finals.handy.controller;

import com.finals.handy.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author xiaoqiang
 * @date $(DATE)-$(TIME)
 */
@RequestMapping(value = "/guest")
@Controller
public class TaskController {
    @Autowired
    TaskService taskService;

    //    添加任务
    @ResponseBody
    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public Map<String, Object> addTask(String AccessToken, String name, String content, MultipartFile[] file) {
        return taskService.addTask(AccessToken, name, content, file);
    }

    //获取任务的总数量
    @ResponseBody
    @RequestMapping(value = "/findTaskCounts", method = RequestMethod.GET)
    public Map<String, Object> getTask() {
        return taskService.findTaskCounts();
    }

    //    查找n个任务
    @ResponseBody
    @RequestMapping(value = "/getTasks", method = RequestMethod.GET)
    public Map<String, Object> getTasks(Integer n) {
        return taskService.getTasks(n);
    }

    //  修改任务 内容 名称
    @ResponseBody
    @RequestMapping(value = "/updateTask", method = RequestMethod.POST)
    public Map<String, Object> updateTask(Integer id, String name, String content) {
        return taskService.updateTask(id, name, content);
    }

    //    举报任务
    @ResponseBody
    @RequestMapping(value = "/reportTask", method = RequestMethod.GET)
    public Map<String, Object> reportTask(String AccessToken, String reason, Integer id) {
        return taskService.reportTask(AccessToken, reason, id);
    }

    //    取消举报任务
    @ResponseBody
    @RequestMapping(value = "/cancelReportTask", method = RequestMethod.GET)
    public Map<String, Object> cancelReportTask(Integer id, Integer taskId) {
        return taskService.cancelReportTask(id, taskId);
    }

    //    接受任务
    @ResponseBody
    @RequestMapping(value = "/acceptTask", method = RequestMethod.GET)
    public Map<String, Object> acceptTask(String AccessToken, Integer id) {
        return taskService.acceptTask(AccessToken, id);
    }


    //    取消任务
    @ResponseBody
    @RequestMapping(value = "/cancelTask", method = RequestMethod.GET)
    public Map<String, Object> cancelTask(String AccessToken, Integer id) {
        return taskService.cancelTask(AccessToken, id);
    }

    //    完成任务
    @ResponseBody
    @RequestMapping(value = "/finishTask", method = RequestMethod.GET)
    public Map<String, Object> finishTask(String AccessToken, Integer id) {
        return taskService.finishTask(AccessToken, id);
    }
    //    删除任务
    @ResponseBody
    @RequestMapping(value = "/deleteTask", method = RequestMethod.GET)
    public Map<String, Object> deleteTask(String AccessToken, Integer id) {
        return taskService.deleteTask(AccessToken, id);
    }

    //    评论
    @ResponseBody
    @RequestMapping(value = "/commentTask", method = RequestMethod.POST)
    public Map<String, Object> commentTask(String AccessToken, String content, Integer taskId) {
        return taskService.commentTask(AccessToken, content, taskId);
    }

    //    举报评论
    @ResponseBody
    @RequestMapping(value = "/reportComment", method = RequestMethod.GET)
    public Map<String, Object> reportComment(String AccessToken, Integer id, String reason) {
        return taskService.reportComment(AccessToken, id, reason);
    }

    //    删除评论
    @ResponseBody
    @RequestMapping(value = "/deleteComment", method = RequestMethod.GET)
    public Map<String, Object> deleteComment(Integer id) {
        return taskService.deleteComment(id);
    }

    //    获取n个评论
    @ResponseBody
    @RequestMapping(value = "/getComments", method = RequestMethod.GET)
    public Map<String, Object> getComments(Integer n,Integer taskId) {
        return taskService.getComments(n,taskId);
    }


}