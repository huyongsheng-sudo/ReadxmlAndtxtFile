package com.example.demo.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author hys
 * @since 2021-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Personnelpositioningattendanceinfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 序号
     */
    @TableField("Id")
    private Integer Id;

    /**
     * 卡号
     */
    @TableField("cardNum")
    private String cardNum;

    /**
     * 入井时间
     */
    @TableField("outTime")
    private LocalDateTime outTime;

    /**
     * 出井时间
     */
    @TableField("inTime")
    private LocalDateTime inTime;

    /**
     * employeeId小于0为车辆大于0为人员
     */
    @TableField("employeeId")
    private Integer employeeId;

    /**
     * 考勤日期
     */
    @TableField("workTeamDay")
    private Integer workTeamDay;

    /**
     * 班次名称目前只有早中晚班三个班次
     */
    @TableField("TeamName")
    private String TeamName;


}
