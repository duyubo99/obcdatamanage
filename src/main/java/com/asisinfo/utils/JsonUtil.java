package com.asisinfo.utils;


import net.sf.json.JSONArray;

public class JsonUtil {
    public static String pageToJson(MyPage page){
        String listJson = JSONArray.fromObject(page.getRecords()).toString();
        String json = "{\"total\":" + page.getTotalRecord() + ",\"rows\":" + listJson + "}";
        return json;
    }
}
