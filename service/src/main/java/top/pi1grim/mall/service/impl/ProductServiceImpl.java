package top.pi1grim.mall.service.impl;

import jakarta.annotation.Resource;
import top.pi1grim.mall.entity.Product;
import top.pi1grim.mall.entity.enhance.ProductEnhance;
import top.pi1grim.mall.mapper.ProductImgMapper;
import top.pi1grim.mall.mapper.ProductMapper;
import top.pi1grim.mall.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 服务实现类
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Resource
    ProductMapper productMapper;

    @Override
    public List<ProductEnhance> productAndImg() {
        return productMapper.productList();
    }
}
