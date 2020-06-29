package com.yczuoxin.demo.eurekaclient2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yczuoxin.demo.eurekaclient2.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseMapper<User> {

    User findById(Long id);

}
