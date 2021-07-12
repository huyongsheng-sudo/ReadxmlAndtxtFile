package com.example.demo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author hys
 * @since 2021-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Safetyinspectionspatialcoordinates implements Serializable {

    private static final long serialVersionUID=1L;

    private String csMineCode;

    private Float csYCoor;

    private Float csXCoor;

    private Float csZCoor;


}
