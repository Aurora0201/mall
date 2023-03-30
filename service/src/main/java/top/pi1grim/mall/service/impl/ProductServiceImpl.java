package top.pi1grim.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import jakarta.annotation.Resource;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    @Override
    public List<ProductEnhance> productAndImg() {
        return productMapper.productList();
    }

    @Override
    public Map<String, Object> productDetail(int productId) {
        Product product = productMapper.selectOne(new LambdaQueryWrapper<Product>().eq(Product::getProductId, productId));
        if(product == null) return null;
        Map<String, Object> map = new HashMap<>();
        map.put("product", product);
        List<ProductImg> productImg = productImgMapper.selectProductImgById(productId);
        List<ProductSku> productSkus = productSkuMapper.selectList(new LambdaQueryWrapper<ProductSku>().eq(ProductSku::getProductId, productId));
        if(productImg != null) map.put("productImg", productImg);
        if(productSkus != null) map.put("productSku", productSkus);
        return map;
    }


}
