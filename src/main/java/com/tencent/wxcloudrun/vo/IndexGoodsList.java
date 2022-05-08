package com.tencent.wxcloudrun.vo;

import com.tencent.wxcloudrun.entity.Product;
import lombok.Data;

@Data
public class IndexGoodsList extends Product {
    private String imageUrl;

    private String title;
}
