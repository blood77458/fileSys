package com.tencent.wxcloudrun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author liucong
 * @since 2022-04-16
 */
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long merchantId;

    private Long addressId;

    private String addressContext;

    private Integer productNumber;

    private BigDecimal price;

    private String status;

    private LocalDateTime createTime;

    private LocalDateTime payTime;


}
