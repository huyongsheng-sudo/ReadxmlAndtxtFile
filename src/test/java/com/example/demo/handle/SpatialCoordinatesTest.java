package com.example.demo.handle;

import com.example.demo.entity.Personnelpositioningattendanceinfo;
import com.example.demo.entity.Safetyinspectionspatialcoordinates;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class SpatialCoordinatesTest {

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
            SpatialCoordinatesListParseHandler handler = new SpatialCoordinatesListParseHandler();
            try {
                // 读取xml文件
                parser.parse("E:\\7.2\\AnalogData\\1xx000002MKJK20100603152330.xml", handler);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("~~~~~共有" + handler.getSafetyinspectionspatialcoordinatesList().size() + "个节点被存储");
            for (Safetyinspectionspatialcoordinates safetyinspectionspatialcoordinates : handler.getSafetyinspectionspatialcoordinatesList()) {
                System.out.println(safetyinspectionspatialcoordinates.getCsMineCode());
                System.out.println(safetyinspectionspatialcoordinates.getCsYCoor());
                System.out.println(safetyinspectionspatialcoordinates.getCsXCoor());
                System.out.println(safetyinspectionspatialcoordinates.getCsZCoor());
                System.out.println("----finish----");
//                personnelpositioningattendanceinfoMapper.insertMsg(personnelpositioningattendanceinfo.getId(),personnelpositioningattendanceinfo.getCardNum(),personnelpositioningattendanceinfo.getOutTime().toString(),personnelpositioningattendanceinfo.getInTime().toString(),personnelpositioningattendanceinfo.getEmployeeId(),personnelpositioningattendanceinfo.getWorkTeamDay(),personnelpositioningattendanceinfo.getTeamName());

            }
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}