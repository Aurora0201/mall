package top.pi1grim.mall.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import jakarta.annotation.Resource;
import lombok.Getter;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.pi1grim.mall.dto.ProductDetailDTO;
import top.pi1grim.mall.entity.Product;
import top.pi1grim.mall.entity.ProductImg;
import top.pi1grim.mall.entity.ProductParams;
import top.pi1grim.mall.entity.ProductSku;
import top.pi1grim.mall.entity.enhance.ProductEnhance;
import top.pi1grim.mall.mapper.ProductImgMapper;
import top.pi1grim.mall.mapper.ProductMapper;
import top.pi1grim.mall.mapper.ProductParamsMapper;
import top.pi1grim.mall.mapper.ProductSkuMapper;
import top.pi1grim.mall.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.pi1grim.mall.vo.VO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    private ProductMapper productMapper;
    @Resource
    private ProductImgMapper productImgMapper;
    @Resource
    private ProductSkuMapper productSkuMapper;
    @Resource
    private ProductParamsMapper productParamsMapper;
    @Resource
    private StringRedisTemplate template;

    @Override
    public List<ProductEnhance> productAndImg() {
        return productMapper.productList();
    }

    @Override
    public ProductDetailDTO productDetail(int productId) {
        //先从Redis查询
        String productInfoString = (String) template.boundHashOps("product").get(String.valueOf(productId));
        //有就直接返回
        if(productInfoString != null) return JSON.parseObject(productInfoString, ProductDetailDTO.class);
        //没有就从数据查询
        Product product = productMapper.selectOne(new LambdaQueryWrapper<Product>().eq(Product::getProductId, productId));
        //如果数据库没有就证明不存在商品
        if (product == null) {
            return null;
        }
        ProductDetailDTO productDetail = ProductDetailDTO.builder()
            .product(product)
            .productImgs(productImgMapper.selectProductImgById(productId))
            .productSkus(productSkuMapper.selectList(new LambdaQueryWrapper<ProductSku>().eq(ProductSku::getProductId, productId)))
            .build();
        //有就放入Redis中
        template.boundHashOps("product").put(String.valueOf(productId), JSON.toJSONString(productDetail));
        //返回商品信息
        return productDetail;
    }


}
