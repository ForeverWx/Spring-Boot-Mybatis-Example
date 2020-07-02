package com.sm.service.service;

import com.sm.service.dao.UserDao;
import com.sm.service.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //自动注入
    @Autowired(required=false)
    private UserDao userDao;

    public User findUserByName(String name) throws Exception{
        return userDao.findUserByName(name);
    }
}
