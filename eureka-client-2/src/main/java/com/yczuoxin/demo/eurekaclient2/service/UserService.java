package com.yczuoxin.demo.eurekaclient2.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yczuoxin.demo.eurekaclient2.entity.User;
import com.yczuoxin.demo.eurekaclient2.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserDao, User> {

    @Autowired
    private UserDao userDao;

    public User findById(Long id) {
        return userDao.selectById(id);
    }
}
