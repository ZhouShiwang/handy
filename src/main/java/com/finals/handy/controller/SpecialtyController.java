package com.finals.handy.controller;

import com.finals.handy.bean.SpecialtyOrder;
import com.finals.handy.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Map;

/**
 * @author zsw
 */
@RestController
public class SpecialtyController {

    @Autowired
    SpecialtyService specialtyService;

    @PostMapping("/specialty/finishOrder")
    public Map<String,Object> finishOrder(String accessToken,@RequestParam("comment") @Size(min = 0,max = 40) String comment,@RequestParam("orderNum") String orderNum,
                                          @RequestParam("score") Integer score){
        Map<String, Object> map = specialtyService.finishOrder(accessToken, comment, orderNum,score);
        return map;
    }


    @PostMapping("/specialty/publishOrder")
    public Map<String,Object> publishOrder(@RequestParam("accessToken") String accessToken,@Valid SpecialtyOrder specialtyOrder){
        Map<String, Object> map = specialtyService.publishOrder(accessToken, specialtyOrder);
        return map;
    }

    @PostMapping("/specialty/receiveOrder")
    public Map<String,Object> receiveOrder(@RequestParam("accessToken") String accessToken,@RequestParam("orderNum") String orderNum){
        Map<String, Object> map = specialtyService.receiveOrder(accessToken, orderNum);
        return map;
    }

    @PostMapping("/user/getMySpecialtyOrder")
    public Map<String,Object> getMySpecialtyOrder(String accessToken, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "3") int pageSize){
        Map<String, Object> map = specialtyService.getMySpecialtyOrder(accessToken, pageNo, pageSize);
        return map;
    }

    @GetMapping("/guest/listSpecialtyOrder")
    public Map<String,Object> listSpecialtyOrder(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "3") int pageSize){
        Map<String, Object> map = specialtyService.listSpecialtyOrder(pageNo, pageSize);
        return map;
    }

    @PostMapping("/specialty/deleteOrder")
    public Map<String,Object> deleteMyOrder(@RequestParam("accessToken") String accessToken,@RequestParam("orderNum") String orderNum){
        Map<String, Object> map = specialtyService.deleteMyOrder(accessToken, orderNum);
        return map;
    }

    @PostMapping("/specialty/agreeDelete")
    public Map<String,Object> agreeDelete(@RequestParam("accessToken")String accessToken,@RequestParam("orderNum") String orderNum){
        Map<String, Object> map = specialtyService.agreeDelete(accessToken, orderNum);
        return map;
    }


}
