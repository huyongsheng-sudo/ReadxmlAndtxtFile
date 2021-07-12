package com.example.demo.controller;


import com.example.demo.JSONResult;
import com.example.demo.service.SafetyinspectionspatialcoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hys
 * @since 2021-07-12
 */
@RestController
@RequestMapping("/safetyinspectionspatialcoordinates")
public class SafetyinspectionspatialcoordinatesController {

    @Autowired
    private SafetyinspectionspatialcoordinatesService safetyinspectionspatialcoordinatesService;

    @PostMapping("/insetSpatialCoordinatesData")
    public JSONResult insetSpatialCoordinatesData() {
        safetyinspectionspatialcoordinatesService.insetSpatialCoordinatesData("E:\\7.2\\AnalogData\\1xx000002MKJK20100603152330.xml");
        return JSONResult.success("success");
    }

}

