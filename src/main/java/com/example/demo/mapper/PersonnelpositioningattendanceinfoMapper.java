package com.example.demo.mapper;

import com.example.demo.entity.Personnelpositioningattendanceinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hys
 * @since 2021-07-02
 */

@Mapper
@Repository
public interface PersonnelpositioningattendanceinfoMapper extends BaseMapper<Personnelpositioningattendanceinfo> {

    public List<Personnelpositioningattendanceinfo> getAllMsg();

    public Integer insertMsg(@Param("id") Integer id,@Param("cardNum") String cardNum,@Param("outTime") String outTime,@Param("inTime") String inTime,@Param("employeeId") Integer employeeId,@Param("workTeamDay") Integer workTeamDay,@Param("TeamName") String TeamName);
}
