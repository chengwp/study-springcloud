package com.cwp.study.springcloud.provider.controller;

import com.cwp.study.springcloud.provider.model.po.StudyUser;
import com.cwp.study.springcloud.provider.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/mysql")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/list")
    public List<StudyUser> list(){
        List<StudyUser> list= userService.selectList();
        return list;
    }
}
