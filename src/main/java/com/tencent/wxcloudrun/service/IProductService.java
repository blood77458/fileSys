package com.tencent.wxcloudrun.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.tencent.wxcloudrun.entity.Product;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liucong
 * @since 2022-04-16
 */
public interface IProductService extends IService<Product> {

    String getIndexGoodsList();
}
