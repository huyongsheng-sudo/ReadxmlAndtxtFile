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
public class Safetyinspectioncoalmineattributes implements Serializable {

    private static final long serialVersionUID=1L;

    private String csMineCode;

    private String csMineName;

    private String csMineShortname;

    private String csWellCode;

    private String csWellName;

    private String csMineAddr;

    private String csBtareaCode;

    private String csMinePhone;

    private String csAdministerCode;

    private String csAdministerName;

    private String csSubrelationCode;

    private String csMinelicenNum;

    private String csMinelicenEffec;

    private String csSplicenNum;

    private String csSplicenEffec;

    private String csProlicenNum;

    private String csProlicenEffec;

    private String csBusilicenNum;

    private String csBusilicenEffec;

    private String csMineheadName;

    private String csMheadlicenNum;

    private String csMheadlicenEffec;

    private String csMheadqualiNum;

    private String csEconomicType;

    private Integer csCapacityAnnual;

    private Integer csCapacityReal;

    private Integer csWorkersTotal;

    private Float csMineField;

    private String csCoalSeam;

    private String csGasLevel;

    private Float csGasAbs;

    private Float csGasCom;

    private String csMineState;


}
