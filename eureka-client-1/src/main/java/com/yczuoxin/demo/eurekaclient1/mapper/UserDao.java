package com.yczuoxin.demo.eurekaclient1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yczuoxin.demo.eurekaclient1.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseMapper<User> {

    User findById(Long id);

}
