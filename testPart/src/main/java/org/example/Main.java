package org.example;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author puka
 * @Description TODO
 * @Date 2023/5/17 15:56
 */

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String jsonStr = "{\"name\":\"ycl\",\"feature\":\"一个小伙子\"}";
        Man man = JSONObject.parseObject(jsonStr, Man.class);
        System.out.println(man.toString());

    }
}
