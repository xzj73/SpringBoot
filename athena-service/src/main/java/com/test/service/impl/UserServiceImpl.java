package com.test.service.impl;


import com.alibaba.dubbo.common.json.JSONArray;
import com.alibaba.dubbo.common.json.JSONObject;
import com.test.dao.UserMapper;

import com.test.domain.User;

import com.test.services.UserService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userService")

public class UserServiceImpl implements UserService  {

   @Resource
   private UserMapper userMapper;


    @Override
    public User get(String id) {


        User user = userMapper.selectByPrimaryKey(id);



        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id",user.getId());
        jsonObject.put("username",user.getUsername());

        return user;


    }

    @Override
    public int create(User item) {
       return userMapper.insert(item);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

}
