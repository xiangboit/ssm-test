/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mingjiang.test.until;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mingjiang.test.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${符柱成} on 2017/3/31.
 */
public class JsonUtils {
    public static String objectToJson(Object data) {
        String json = JSONArray.toJSONString(data);
        return json;
    }
    public static User jsonObjectToUser(String userString) {
        User user = JSONObject.parseObject(userString.toString(),User.class);
        return user;
    }
    public static List<User> objectToUser(JSONArray array){
        List<User> userList =new ArrayList<User>();
        for (int i=0;i<array.size();i++) {
            System.out.print("array.get(i)    "+array.get(i).toString());
            //parseObject解析的是一个字符串，强转成为String是不行的，必须打印成String语句
            User user = JSONObject.parseObject(array.get(i).toString(),User.class);
            userList.add(user);
        }
        return userList;
    }
}
