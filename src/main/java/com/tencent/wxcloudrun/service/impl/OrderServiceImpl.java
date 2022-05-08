package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.entity.Order;
import com.tencent.wxcloudrun.mapper.OrderMapper;
import com.tencent.wxcloudrun.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liucong
 * @since 2022-04-16
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
