package top.pi1grim.mall.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.pi1grim.mall.mapper.ProductMapper;
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
    private ProductMapper productMapper;
    @GetMapping("/list")
    public VO list() {
        productMapper.productList();
        return VO.getRetVOByCode(10, productMapper.productList(), ProductStatus.class);
    }
}
