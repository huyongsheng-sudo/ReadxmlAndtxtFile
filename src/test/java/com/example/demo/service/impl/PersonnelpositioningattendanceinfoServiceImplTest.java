package com.example.demo.service.impl;

import com.example.demo.service.PersonnelpositioningattendanceinfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonnelpositioningattendanceinfoServiceImplTest {

    @Autowired
    private PersonnelpositioningattendanceinfoService personnelpositioningattendanceinfoService;

    @Test
    void getAllMsg() {
        System.out.println(personnelpositioningattendanceinfoService.getAllMsg());
    }

    @Test
    void insertMsg() {
        personnelpositioningattendanceinfoService.insertMsg();
    }
}