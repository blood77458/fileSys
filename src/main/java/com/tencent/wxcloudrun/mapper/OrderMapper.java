package com.tencent.wxcloudrun.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tencent.wxcloudrun.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author liucong
 * @since 2022-04-16
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
