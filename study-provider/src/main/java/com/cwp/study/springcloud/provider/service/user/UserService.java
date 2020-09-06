package com.cwp.study.springcloud.provider.service.user;

import com.cwp.study.springcloud.provider.model.po.StudyUser;

import java.util.List;

public interface UserService {

    List<StudyUser> selectList();
}
