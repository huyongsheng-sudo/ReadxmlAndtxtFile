package com.example.demo.controller;


import com.example.demo.JSONResult;
import com.example.demo.entity.Personnelpositioningattendanceinfo;
import com.example.demo.service.PersonnelpositioningattendanceinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hys
 * @since 2021-07-02
 */
@RestController
@RequestMapping("/personnelpositioningattendanceinfo")
public class PersonnelpositioningattendanceinfoController {

    @Autowired
    private PersonnelpositioningattendanceinfoService personnelpositioningattendanceinfoService;

    @PostMapping("/getAllMsg")
    public JSONResult getAllMsg() {
        List<Personnelpositioningattendanceinfo> list = personnelpositioningattendanceinfoService.getAllMsg();
        return JSONResult.success(list);
    }

    @PostMapping("/insertMsg")
    public JSONResult insertMsg() {
        personnelpositioningattendanceinfoService.insertMsg();
        return JSONResult.success("success");
    }

}

