package top.pi1grim.mall.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import top.pi1grim.mall.service.CategoryService;
import top.pi1grim.mall.type.CategoryStatus;
import top.pi1grim.mall.vo.ResultVO;

/**
 * <p>
 * 商品分类 前端控制器
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
    @Resource
    CategoryService categoryService;
    @GetMapping("/list")
    public ResultVO list() {
        return ResultVO.getRetVOByCode(10, categoryService.categoryList(), CategoryStatus.class);
    }
}
