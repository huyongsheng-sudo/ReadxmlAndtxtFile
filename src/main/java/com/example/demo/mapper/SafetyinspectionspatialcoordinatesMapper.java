package com.example.demo.mapper;

import com.example.demo.entity.Safetyinspectionspatialcoordinates;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hys
 * @since 2021-07-12
 */

@Mapper
@Repository
public interface SafetyinspectionspatialcoordinatesMapper extends BaseMapper<Safetyinspectionspatialcoordinates> {

    public Integer insetSpatialCoordinatesData(@Param("csMineCode") String csMineCode,@Param("csYCoor") Float csYCoor,@Param("csXCoor") Float csXCoor,@Param("csZCoor") Float csZCoor);

}
