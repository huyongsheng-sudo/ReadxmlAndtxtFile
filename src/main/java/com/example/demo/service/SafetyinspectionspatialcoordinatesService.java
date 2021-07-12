package com.example.demo.service;

import com.example.demo.entity.Safetyinspectionspatialcoordinates;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hys
 * @since 2021-07-12
 */
@Service
public interface SafetyinspectionspatialcoordinatesService extends IService<Safetyinspectionspatialcoordinates> {

    public Integer insetSpatialCoordinatesData(String url);

}
