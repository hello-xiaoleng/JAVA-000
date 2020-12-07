package com.xiaoleng.datasource02.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("test")
@Data
public class Test {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("user_name")
    private String userName;
}
