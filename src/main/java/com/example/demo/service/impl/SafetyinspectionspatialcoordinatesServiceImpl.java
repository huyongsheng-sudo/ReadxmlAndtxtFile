package com.example.demo.service.impl;

import com.example.demo.entity.Safetyinspectionspatialcoordinates;
import com.example.demo.handle.SpatialCoordinatesListParseHandler;
import com.example.demo.mapper.SafetyinspectionspatialcoordinatesMapper;
import com.example.demo.service.SafetyinspectionspatialcoordinatesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hys
 * @since 2021-07-12
 */
@Service
public class SafetyinspectionspatialcoordinatesServiceImpl extends ServiceImpl<SafetyinspectionspatialcoordinatesMapper, Safetyinspectionspatialcoordinates> implements SafetyinspectionspatialcoordinatesService {

    @Autowired
    private SafetyinspectionspatialcoordinatesMapper safetyinspectionspatialcoordinatesMapper;

    @Override
    public Integer insetSpatialCoordinatesData(String url) {
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
                parser.parse(url, handler);
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
                safetyinspectionspatialcoordinatesMapper.insetSpatialCoordinatesData(safetyinspectionspatialcoordinates.getCsMineCode(),safetyinspectionspatialcoordinates.getCsYCoor(),safetyinspectionspatialcoordinates.getCsXCoor(),safetyinspectionspatialcoordinates.getCsZCoor());
            }
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
