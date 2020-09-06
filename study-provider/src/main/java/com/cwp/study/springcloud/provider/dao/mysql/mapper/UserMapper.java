package com.cwp.study.springcloud.provider.dao.mysql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cwp.study.springcloud.provider.model.po.StudyUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<StudyUser> {
}
