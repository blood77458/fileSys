package com.tencent.wxcloudrun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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
@TableName("user_cart")
@Data
public class UserCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long merchantId;

    private Long productId;

    private String image;

    private String attrVal;

    private Long stock;

    private String title;

    private String price;

    private Integer number;

    private LocalDateTime createTime;


}
