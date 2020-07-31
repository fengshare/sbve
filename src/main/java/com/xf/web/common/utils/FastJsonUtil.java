package com.xf.web.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于阿里巴巴 fastjson所做的工具类
 */
public class FastJsonUtil {

    /**
     * 将对象转成json串
     *
     * @param object 任意类型
     */
    public static String toJSONString(Object object) {
        // 显示Javabean中的空值.并且禁止循环引用检测
        return JSON.toJSONString(object, SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
    }


    // 输出json
    public static void write_json(HttpServletResponse response, String jsonString) {
        response.setContentType("application/json;utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }


    /**
     * 将json数据转换成pojo对象list
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> clazz) {
        try {
            List<T> list = JSON.parseArray(jsonData, clazz);
            return list;
        } catch (Exception e) {
        }

        return null;
    }

    /**
     * 将json转换成map
     */
    public static Map<String, Object> json2Map(String json) {
        try {
            return JSON.parseObject(json, Map.class);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 将json转换成map
     */
    public static <T> T jsonToObject(String json, TypeReference<T> type) {
        try {
            return JSON.parseObject(json, type);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 将json数据转换成pojo对象
     */
    public static <T> T jsonToObject(String jsonData, Class<T> clazz) {
        try {
            T t = JSON.parseObject(jsonData, clazz);
            return t;
        } catch (Exception e) {
        }

        return null;
    }

    /**
     * ajax提交后回调的json字符串
     *
     * @return
     */
    public static String ajaxResult(boolean success, String message) {
        Map map = new HashMap();
        map.put("success", success);// 是否成功
        map.put("message", message);// 文本消息
        String json = JSON.toJSONString(map, SerializerFeature.WriteMapNullValue);
        return json;
    }

    /**
     * 判断某对象是不是实体
     *
     * @param object
     * @return
     */
    private static boolean isEntity(Object object) {
        if (object instanceof String) {
            return false;
        }
        if (object instanceof Integer) {
            return false;
        }
        if (object instanceof Long) {
            return false;
        }
        if (object instanceof java.math.BigDecimal) {
            return false;
        }
        if (object instanceof Date) {
            return false;
        }
        if (object instanceof java.util.Collection) {
            return false;
        }
        return true;

    }

    @Test
    public  void maina() {


//        System.out.println(FastJsonUtil.toJSONString(Lists.newArrayList( "sTableTr-remark",
//                "sTableTr-remarkFirst")));
//        System.out.println(FastJsonUtil.toJSONString(Lists.newArrayList( "primaryCare","highRisk")));
//
//        // 表格类型 如：病区动态（area_action）、左侧表格(left_table)，右侧表格(right_table)，备注(remark)。
//        TestDataSourceConfig dataSourceConfig = new TestDataSourceConfig()
//                .setTableNameType("area_action")
//                .setTableType("sTable")
//                .setTableName("病区动态")
//                .setDataSourceCodes(Lists.newArrayList("m123","m124","m125","m126","m127","m128","m129","m130","m131"));
//        TestDataSourceConfig dataSourceConfig1 = new TestDataSourceConfig()
//                .setTableNameType("left_table")
//                .setTableType("sTable");
//        TestDataSourceConfig dataSourceConfig2 = new TestDataSourceConfig()
//                .setTableNameType("right_table")
//                .setTableType("sTable");
//        TestDataSourceConfig dataSourceConfig3 = new TestDataSourceConfig()
//                .setTableNameType("remark")
//                .setTableType("sTable");
//
//        System.out.println(FastJsonUtil.toJSONString(Lists.newArrayList( "病人总数","入园人数"
//        ,"出院人数","特级护理"
//        ,"一级护理","二级护理"
//        ,"三级护理","转入"
//        ,"转出")));
//
//
//        List<TestDataSourceConfig> list = Lists.newArrayList(dataSourceConfig,dataSourceConfig1,dataSourceConfig2,dataSourceConfig3);
//
//        System.out.println(FastJsonUtil.toJSONString(list));
//
//        System.out.println(FastJsonUtil.toJSONString(new TestDataSourceConfig()
//        .setRemarkTypeValue("1")
//        .setTitleTableType("sTableTdTitle")
//        .setTitle("备注")));



    }



}
