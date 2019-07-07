package com.example.springbootdemo;

import com.example.vo.user.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author frankwin608
 * @create 2018-09-21 0:24
 * @desc 测试初始化数据初始值
 **/
public class TestArray {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testIntArrayInitValue(){
        int tt[] = new int[10];
        logger.info("tt = {}" , tt);
    }

    @Test
    public void testIntegerArrayInitValue(){
        Integer tt[] = new Integer[10];
        logger.info("tt = {}" , tt);
    }
    @Test
    public void testArraysFill(){
        int tt[] = new int[10];
        Arrays.fill(tt,-1);
        logger.info("tt = {}" , tt);
    }

    @Test
    public void testHashMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("1",null);

        map.getOrDefault("1","2333");
        logger.info("map = {}", map);

        //test putIfAbsent
        map.put("2","33333");
        Object o = map.putIfAbsent("2", "44444");
        Object o1 = map.get("2");
        logger.info("o = {}", o);
        logger.info("o1 = {}", o1);
    }

    @Test
    public void testClone(){
        HashMap<String, User> map = new HashMap<>();
        User user = new User();
        map.put("23333",user);
        HashMap<String, User> newMap = (HashMap<String, User>)map.clone();
        logger.info("newMap before = {}", newMap);
        logger.info("map before= {}", map);

        logger.info("newMap after = {}", newMap);
        logger.info("map after = {}", map);
    }

    @Test
    public void testHashMapSize(){
        HashMap<Object, Object> map = new HashMap<>(100);
        System.out.println("map.size() = " + map.size());
    }

}
