package com.example.config;

import org.springframework.context.ApplicationListener;

/**
 * @author frankwin608
 * @create 2018-09-17 10:36
 * @desc 自定义监听器
 **/
public class MyListener implements ApplicationListener<MyApplicationEvent> {
    @Override
    public void onApplicationEvent(MyApplicationEvent event) {

    }
}
