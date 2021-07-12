package com.example.demo.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonnelpositioningattendanceinfoMapperTest {

    @Autowired
    private PersonnelpositioningattendanceinfoMapper personnelpositioningattendanceinfoMapper;

    @Test
    void getAllMsg() {
        System.out.println(personnelpositioningattendanceinfoMapper.getAllMsg());
        System.out.println(111);
    }

    @Test
    void insertMsg() {
        personnelpositioningattendanceinfoMapper.insertMsg(0,"0","2021-06-28 09:35:53","2021-06-28 08:35:53",0,0,"nice");
    }
}