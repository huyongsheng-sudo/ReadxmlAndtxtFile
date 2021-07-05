package com.example.demo.service;

import com.example.demo.entity.Personnelpositioningattendanceinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hys
 * @since 2021-07-02
 */
@Service
public interface PersonnelpositioningattendanceinfoService extends IService<Personnelpositioningattendanceinfo> {

    public List<Personnelpositioningattendanceinfo> getAllMsg();

    public Integer insertMsg();


}
