package com.cwp.study.springcloud.provider.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cwp.study.springcloud.provider.dao.mysql.mapper.UserMapper;
import com.cwp.study.springcloud.provider.model.po.StudyUser;
import com.cwp.study.springcloud.provider.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    public UserMapper userMapper;

    @Override
    public List<StudyUser> selectList() {
        QueryWrapper<StudyUser> queryWrapper = new QueryWrapper();
        IPage<StudyUser> userPage = new Page<>(1, 2);//参数1是当前页，参数2是每页个数
        userPage = userMapper.selectPage(userPage, queryWrapper);
        List<StudyUser> list = userPage.getRecords();
        return list;
    }
}
