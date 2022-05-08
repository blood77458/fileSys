package com.tencent.wxcloudrun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tencent.wxcloudrun.entity.Product;
import com.tencent.wxcloudrun.entity.ProductSpec;
import com.tencent.wxcloudrun.entity.SysMerchant;
import com.tencent.wxcloudrun.mapper.ProductMapper;
import com.tencent.wxcloudrun.mapper.ProductSpecMapper;
import com.tencent.wxcloudrun.mapper.SysMerchantMapper;
import com.tencent.wxcloudrun.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tencent.wxcloudrun.vo.IndexGoodsList;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liucong
 * @since 2022-04-16
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    private final Gson gson = new Gson();
    @Autowired
    private ProductSpecMapper productSpecMapper;
    @Autowired
    private SysMerchantMapper sysMerchantMapper;

    @Override
    public String getIndexGoodsList() {
        List<Product> products = baseMapper.selectList(new LambdaQueryWrapper<Product>().orderByDesc(Product::getClickNumber).last("limit 8"));
        if (CollectionUtils.isEmpty(products)) {
            return null;
        }
        List<Long> productIds = new ArrayList<>();
        List<Long> merchantIds = new ArrayList<>();

        for (Product product : products) {
            productIds.add(product.getId());
            merchantIds.add(product.getMerchantId());
        }

        List<ProductSpec> productSpecs = productSpecMapper.selectList(new LambdaQueryWrapper<ProductSpec>().in(ProductSpec::getProductId, productIds));
        List<SysMerchant> sysMerchants = sysMerchantMapper.selectList(new LambdaQueryWrapper<SysMerchant>().in(SysMerchant::getUserId, merchantIds));
        Map<Long, String> collect1 = productSpecs.stream().collect(Collectors.toMap(ProductSpec::getProductId, ProductSpec::getImageUrl, (a1, a2) -> a2));
        Map<Long, String> collect2 = sysMerchants.stream().collect(Collectors.toMap(SysMerchant::getId, SysMerchant::getName, (a1, a2) -> a2));
        List<IndexGoodsList> indexGoodsLists = new ArrayList<>();
        for (Product product : products) {
            IndexGoodsList indexGoodsList = new IndexGoodsList();
            BeanUtils.copyProperties(product, indexGoodsList);
            indexGoodsList.setImageUrl(collect1.get(product.getId()));
            indexGoodsList.setTitle(collect2.get(product.getId()));
            indexGoodsLists.add(indexGoodsList);
        }
        return gson.toJson(indexGoodsLists);
    }
}
