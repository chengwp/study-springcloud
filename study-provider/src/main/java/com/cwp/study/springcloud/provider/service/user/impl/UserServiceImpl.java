package com.cwp.study.springcloud.provider.service.user.impl;

import com.cwp.study.springcloud.provider.dao.mysql.mapper.UserMapper;
import com.cwp.study.springcloud.provider.model.po.StudyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {


    @Autowired
    public UserMapper userMapper;


    public List<StudyUser>  selectList(){
        return null;
    }
}
