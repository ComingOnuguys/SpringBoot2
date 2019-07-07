package com.example.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * @author frankwin608
 * @create 2018-08-14 0:15
 * @desc 测试BeanPostProcessor
 **/
//@Component
public class MyBeanPostProcessor implements BeanFactoryPostProcessor{

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Iterator<String> beanNamesIterator = beanFactory.getBeanNamesIterator();
        while(beanNamesIterator.hasNext()){
            System.out.println("beanNamesIterator.next() = " + beanNamesIterator.next());
        }

    }
}
