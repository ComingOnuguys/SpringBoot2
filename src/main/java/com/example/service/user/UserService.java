package com.example.service.user;

import com.example.vo.user.User;

import java.util.List;

/**
 * @author frankwin608
 * @create 2018-08-12 0:41
 * @desc 用于测试spring事务失效 与 解决方案
 **/

public interface UserService {
    int saveCharge();
    int insertUser();
    int updateUser(List<User> users);
}
