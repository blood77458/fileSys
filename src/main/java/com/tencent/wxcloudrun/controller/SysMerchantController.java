package com.tencent.wxcloudrun.controller;


import com.tencent.wxcloudrun.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liucong
 * @since 2022-04-16
 */
@RestController
@RequestMapping("/project/sys-merchant")
public class SysMerchantController {

    @Autowired
    private IProductService productService;

    @RequestMapping("goodsList")
    public String goodsList() {

        return productService.getIndexGoodsList();
    }

}
