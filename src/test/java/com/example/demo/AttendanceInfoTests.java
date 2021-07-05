package com.example.demo;


import com.example.demo.entity.Personnelpositioningattendanceinfo;
import com.example.demo.handle.AttendanceInfoListParseHandler;
import com.example.demo.mapper.PersonnelpositioningattendanceinfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

@SpringBootTest
class AttendanceInfoTests {

    @Autowired
    PersonnelpositioningattendanceinfoMapper personnelpositioningattendanceinfoMapper;

    @Test
    void contextLoads() {
        //1.获取一个SAXParserFactory的实例对象
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.通过factory的newSAXParser()方法获取一个SAXParser类的对象。
        try {
            SAXParser parser = null;
            try {
                parser = factory.newSAXParser();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
            //创建SAXParserHandler对象
            AttendanceInfoListParseHandler handler = new AttendanceInfoListParseHandler();
            try {
                // 读取xml文件
                parser.parse("E:\\7.2\\test.xml", handler);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("~~~~~共有" + handler.getPersonnelpositioningattendanceinfoList().size() + "个节点被存储");
            for (Personnelpositioningattendanceinfo personnelpositioningattendanceinfo : handler.getPersonnelpositioningattendanceinfoList()) {
                System.out.println(personnelpositioningattendanceinfo.getId());
                System.out.println(personnelpositioningattendanceinfo.getCardNum());
                System.out.println(personnelpositioningattendanceinfo.getOutTime());
                System.out.println(personnelpositioningattendanceinfo.getInTime());
                System.out.println(personnelpositioningattendanceinfo.getEmployeeId());
                System.out.println(personnelpositioningattendanceinfo.getWorkTeamDay());
                System.out.println(personnelpositioningattendanceinfo.getTeamName());
                System.out.println("----finish----");
                personnelpositioningattendanceinfoMapper.insertMsg(personnelpositioningattendanceinfo.getId(),personnelpositioningattendanceinfo.getCardNum(),personnelpositioningattendanceinfo.getOutTime().toString(),personnelpositioningattendanceinfo.getInTime().toString(),personnelpositioningattendanceinfo.getEmployeeId(),personnelpositioningattendanceinfo.getWorkTeamDay(),personnelpositioningattendanceinfo.getTeamName());

            }
        } catch (SAXException e) {
            e.printStackTrace();
        }


    }




}
