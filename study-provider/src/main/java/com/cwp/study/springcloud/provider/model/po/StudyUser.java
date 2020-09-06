package com.cwp.study.springcloud.provider.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "study_user")//指定表名
public class StudyUser {

    //value与数据库主键列名一致，若实体类属性名与表主键列名一致可省略value
    @TableId(value = "user_id",type = IdType.AUTO)//指定自增策略
    private Integer userId;
    //若没有开启驼峰命名，或者表中列名不符合驼峰规则，
    // 可通过该注解指定数据库表中的列名，
    // exist标明数据表中有没有对应列
    @TableField(value = "user_name",exist = true)
    private String userName;
}
