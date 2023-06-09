package top.pi1grim.mall.service;

import top.pi1grim.mall.dto.ProductDetailDTO;
import top.pi1grim.mall.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import top.pi1grim.mall.entity.enhance.ProductEnhance;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 服务类
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
public interface ProductService extends IService<Product> {
    List<ProductEnhance> productAndImg();

    ProductDetailDTO productDetail(int productId);
}
