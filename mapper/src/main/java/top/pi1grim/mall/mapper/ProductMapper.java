package top.pi1grim.mall.mapper;

import top.pi1grim.mall.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.pi1grim.mall.entity.enhance.ProductEnhance;

import java.util.List;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 Mapper 接口
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
public interface ProductMapper extends BaseMapper<Product> {
    List<ProductEnhance> productList();
}
