package com.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author xstoop
 * @date 2022/1/25 下午3:22
 */
@Data
@TableName("users")
public class Users {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer age;

    private String name;

    @TableField("create_time")
    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @TableField(exist = false)
    private String remark;

}
