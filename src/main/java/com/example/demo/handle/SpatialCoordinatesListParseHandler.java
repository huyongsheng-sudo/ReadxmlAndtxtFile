package com.example.demo.handle;

import com.example.demo.entity.Personnelpositioningattendanceinfo;
import com.example.demo.entity.Safetyinspectionspatialcoordinates;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SpatialCoordinatesListParseHandler extends DefaultHandler {
    int listIndex = 0;
    String value = null;

    String cs_mine_code = null;
    Safetyinspectionspatialcoordinates safetyinspectionspatialcoordinates = null;

    private ArrayList<Safetyinspectionspatialcoordinates> safetyinspectionspatialcoordinatesList = new ArrayList<>();

    public ArrayList<Safetyinspectionspatialcoordinates> getSafetyinspectionspatialcoordinatesList() {
        return safetyinspectionspatialcoordinatesList;
    }

    /**
     * 标识解析开始
     *
     * @throws SAXException
     */
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("SAX解析开始");
    }

    /**
     * 用来标识解析结束
     *
     * @throws SAXException
     */
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("SAX解析结束");
    }

    /**
     * 用来遍历xml文件的开始标签
     * 解析xml元素
     *
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        super.startElement(uri, localName, qName, attributes);
        // 扫描data节点
        if (qName.equals("root")) {
            // 扫描根节点
            System.out.println("节点名是：" + qName + "---");
        } else if (qName.equals("head")) {
            for (int i = 0 ; i < attributes.getLength(); i++) {
                if (attributes.getQName(i).equals("cs_mine_code")) {
                    cs_mine_code = attributes.getValue(i);
                }
            }
        } else{
            //设置日期格式
//            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            listIndex++;
            safetyinspectionspatialcoordinates = new Safetyinspectionspatialcoordinates();
            //开始解析
            System.out.println("======================开始遍历第" + listIndex + "列的内容=================");
            /* 根据属性名称获取属性值*/
            System.out.println("该节点的长度是：" + attributes.getLength());

            for (int i = 0 ; i < attributes.getLength(); i++) {
                System.out.println("节点名称是：" + attributes.getQName(i) + "节点值是：" + attributes.getValue(i));
                safetyinspectionspatialcoordinates.setCsMineCode(cs_mine_code);
                switch (attributes.getQName(i)) {

                    case "cs_y_coor" :
                        safetyinspectionspatialcoordinates.setCsYCoor(Float.valueOf(attributes.getValue(i)));
                        break;
                    case "cs_x_coor" :
                        safetyinspectionspatialcoordinates.setCsXCoor(Float.valueOf(attributes.getValue(i)));
                        break;
                    case "cs_z_coor" :
                        safetyinspectionspatialcoordinates.setCsZCoor(Float.valueOf(attributes.getValue(i)));
                        break;
                    default :
                        break;
                }
            }
            System.out.println("该节点是：" + safetyinspectionspatialcoordinates);
        }
    }

    /**
     * 用来遍历xml文件结束标签
     *
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        //在清空master对象之前先保存
        if (safetyinspectionspatialcoordinates != null) {
            safetyinspectionspatialcoordinatesList.add(safetyinspectionspatialcoordinates);
            System.out.println("======================结束遍历第" + listIndex + "列的内容=================");
        }
        //把master节点清空，方便解析下一个节点
        safetyinspectionspatialcoordinates = null;
    }

    /**
     * 获取文本
     * 重写charaters()方法时，
     * String(byte[] bytes,int offset,int length)的构造方法进行数组的传递
     * 去除解析时多余空格
     *
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        /**
         * ch 代表节点中的所有内容，即每次遇到一个标签调用characters方法时，数组ch实际都是整个XML文档的内容
         * 如何每次去调用characters方法时我们都可以获取不同的节点属性？这时就必须结合start（开始节点）和length（长度）
         */
        super.characters(ch, start, length);
        value = new String(ch, start, length);//value获取的是文本（开始和结束标签之间的文本）
        System.out.println(value);
        //如果value去掉空格后不是空字符串
        if (!value.trim().equals("")) {
            System.out.println("节点值是：" + value);

        }
    }
}
