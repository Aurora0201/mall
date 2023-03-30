package top.pi1grim.mall.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import top.pi1grim.mall.entity.ProductParams;
import top.pi1grim.mall.mapper.ProductMapper;
import top.pi1grim.mall.service.ProductParamsService;
import top.pi1grim.mall.service.ProductService;
import top.pi1grim.mall.type.ProductStatus;
import top.pi1grim.mall.vo.VO;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 前端控制器
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Resource
    private ProductService productService;
    @Resource
    private ProductParamsService productParamsService;
    @GetMapping("/list")
    public VO list() {
        return VO.getRetVOByCode(10, productService.productAndImg(), ProductStatus.class);
    }

    @GetMapping("/detail/{productId}")
    public VO detail(@PathVariable int productId) {
        return VO.getRetVOByCode(20, productService.productDetail(productId), ProductStatus.class);
    }

    @GetMapping("/param/{productId}")
    public VO param(@PathVariable int productId) {
        return VO.getRetVOByCode(25, productParamsService.getOne(new LambdaQueryWrapper<ProductParams>().eq(ProductParams::getProductId, productId)), ProductStatus.class);
    }
}
