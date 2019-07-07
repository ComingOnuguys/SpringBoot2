package com.example.controller;

import com.example.mapper.UserMapper;
import com.example.service.user.UserService;
import com.example.vo.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class HelloWorldController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired(required = false)
    private UserMapper userMapper;

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    /*@RequestMapping("/testSpringTransaction")
    public String testSpringTransaction(){

        userMapper.selectByPrimaryKey("");

        return "testSpringTransaction";
    }


    @PostMapping("/testMvcBindList")
    public List<User> testMvcBindList(@RequestBody List<String> ids){
        logger.info("ids = " + ids);
        List<User> list = userMapper.selectUsersByIds(ids);
        logger.info("testMvcBindList = " + list);
        return list;
    }

    @PostMapping("/testMvcBindListQueryByMap")
    public void testMvcBindListQueryByMap(@RequestBody List<String> ids){
        logger.info("ids = " + ids);
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("ids",ids);
        List<User> list = userMapper.selectUsersByMapIds(hashMap);
        logger.info("testMvcBindList = " + list);
    }

    @PostMapping("/testMvcBindListMap")
    public void testMvcBindListMap(@RequestBody List<Map> mapList){
        logger.info("mapList = " + mapList);
        List<String> userids = mapList.stream().map(x -> (String)x.get("userid")).collect(Collectors.toList());
        logger.info("userids = " + userids);
        List<User> list = userMapper.selectUsersByIds(userids);
        logger.info("testMvcBindListMap = " + list);
    }

    @PostMapping("/testMvcBindArray")
    public void testMvcBindArray(@RequestBody String[] ids){
        logger.info("ids = " + ids);
        List<String> userids = Arrays.asList(ids);
        List<User> list = userMapper.selectUsersByIds(userids);
        logger.info("testMvcBindArray = " + list);
    }

    @PostMapping("/testMvcBindMap")
    public void testMvcBindMap(@RequestBody Map map){
        logger.info("map = " + map);
        List<String> userids = Arrays.asList((String) map.get("userid"));
        List<User> list = userMapper.selectUsersByIds(userids);
        logger.info("testMvcBindMap = " + list);
    }

    @PostMapping("/testMvcBindModel")
    public void testMvcBindModel(@RequestBody User user){
        logger.info("user = " + user);
        List<String> userids = Arrays.asList(user.getUserid());
        List<User> list = userMapper.selectUsersByIds(userids);
        logger.info("testMvcBindModel = " + list);
    }

    @PostMapping("/testMvcBindString")
    public void testMvcBindString(@RequestBody String id){
        logger.info("id = " + id);
        List<String> userids = Arrays.asList(id);
        List<User> list = userMapper.selectUsersByIds(userids);
        logger.info("testMvcBindString = " + list);
    }*/
}