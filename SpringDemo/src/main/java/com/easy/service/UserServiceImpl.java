package com.easy.service;

import com.easy.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    private User user;
    @Autowired
    private User user1;
    @Override
    public void test() {
        System.out.println(user.equals(user1));
    }
}
