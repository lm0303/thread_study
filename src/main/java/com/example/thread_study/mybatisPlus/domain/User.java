package com.example.thread_study.mybatisPlus.domain;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author : limeng
 * @date : 2023/3/8
 * @description :
 */
@Data
@Builder
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Long managerId;
    @TableField(insertStrategy = FieldStrategy.NOT_NULL)
    private LocalDateTime createTime;

    @TableField(insertStrategy = FieldStrategy.NOT_NULL)
    private LocalDateTime updateTime;
}
