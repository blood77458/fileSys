package com.tencent.wxcloudrun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author liucong
 * @since 2022-04-16
 */
@TableName("user_address")
@Data
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId;

    private String name;

    private String mobile;

    private String addressName;

    private String address;

    private String area;

    private Integer defaultMark;

    private LocalDateTime createTime;


}
