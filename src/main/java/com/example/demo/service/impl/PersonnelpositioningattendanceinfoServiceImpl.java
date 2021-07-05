package com.example.demo.service.impl;

import com.example.demo.entity.Personnelpositioningattendanceinfo;
import com.example.demo.handle.AttendanceInfoListParseHandler;
import com.example.demo.mapper.PersonnelpositioningattendanceinfoMapper;
import com.example.demo.service.PersonnelpositioningattendanceinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hys
 * @since 2021-07-02
 */
@Service
public class PersonnelpositioningattendanceinfoServiceImpl extends ServiceImpl<PersonnelpositioningattendanceinfoMapper, Personnelpositioningattendanceinfo> implements PersonnelpositioningattendanceinfoService {

    @Autowired
    private PersonnelpositioningattendanceinfoMapper personnelpositioningattendanceinfoMapper;

    @Override
    public List<Personnelpositioningattendanceinfo> getAllMsg() {
        List<Personnelpositioningattendanceinfo> list = personnelpositioningattendanceinfoMapper.getAllMsg();
        return list;
    }

    @Override
    public Integer insertMsg() {

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
        return 1;
    }
}
