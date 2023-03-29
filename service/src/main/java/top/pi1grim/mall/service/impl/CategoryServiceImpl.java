package top.pi1grim.mall.service.impl;

import jakarta.annotation.Resource;
import top.pi1grim.mall.entity.Category;
import top.pi1grim.mall.entity.enhance.CategoryEnhance;
import top.pi1grim.mall.mapper.CategoryMapper;
import top.pi1grim.mall.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品分类 服务实现类
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Resource
    CategoryMapper categoryMapper;
    @Override
    public List<CategoryEnhance> categoryList() {
        return categoryMapper.selectSubcategory(0);
    }
}
