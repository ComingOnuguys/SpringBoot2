package com.example.service.user.impl;

import com.example.mapper.UserMapper;
import com.example.service.user.UserService;
import com.example.vo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author frankwin608
 * @create 2018-08-12 0:44
 * @desc 测试spring事务失效与解决方案实现类
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    /**
     * 事务失效的根本原因在于this调用时没有动态代理
     * 事务生效的原因在于controller调用一个有事务的另一个类的方法，controller调用时使用了动态代理
     * 所以看事务是否生效在于被调的第一个方法是否有事务
     * @return
     */
    @Transactional
    //@Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public int saveCharge() {
        User user = new User();
        user.setName("杨知颖" + 999);
        user.setGender(0);
        user.setAge(BigDecimal.TEN);
        user.setBalance(BigDecimal.valueOf(Long.MAX_VALUE));
        user.setAddress("帝王大厦999层");
        userMapper.insert(user);
        System.out.println("user = " + user);
        //int count1 = userMapper.updateByPrimaryKey(user);
        return insertUser();
    }

    //@Transactional
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public int insertUser() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setName("杨知颖" + i);
            user.setGender(0);
            user.setAge(BigDecimal.TEN);
            user.setBalance(BigDecimal.valueOf(Long.MAX_VALUE));
            user.setAddress("深圳湾" + i + "号");
            users.add(user);
        }

        int count = userMapper.batchInsertUser(users);
        System.out.println("count = " + count);

        //int i = 1/0;

        User user = new User();
        user.setName("杨知颖" + 888);
        user.setGender(0);
        user.setAge(BigDecimal.TEN);
        user.setBalance(BigDecimal.valueOf(Long.MAX_VALUE));
        user.setAddress("帝王大厦888层");
        userMapper.insert(user);
        //throw new RuntimeException();
        return count;
    }

    @Override
    public int updateUser(List<User> users) {
        User user = users.get(0);
        user.setAddress("帝王大厦888层");
        return userMapper.updateByPrimaryKey(user);
    }


}
