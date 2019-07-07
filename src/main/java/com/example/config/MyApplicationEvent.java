package com.example.config;

import org.springframework.context.ApplicationEvent;

/**
 * @author frankwin608
 * @create 2018-09-17 10:30
 * @desc 自定义事件
 **/
public class MyApplicationEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyApplicationEvent(Object source) {
        super(source);
    }
}
