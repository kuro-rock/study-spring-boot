package com.example.sample.service;

import com.example.sample.dao.UserDao;
import com.example.sample.dto.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public List<User> selectAll(){
        List<User> users = userDao.selectAll();
        return users;
    }

    public User create(final User inputUser) {
        Assert.notNull(inputUser, "inputUser must not be null");
        userDao.insert(inputUser);

        return inputUser;
    }
}
