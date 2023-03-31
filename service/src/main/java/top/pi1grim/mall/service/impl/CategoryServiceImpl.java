package top.pi1grim.mall.service.impl;

import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
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
    private CategoryMapper categoryMapper;
    @Resource
    private StringRedisTemplate template;
    @Override
    public List<CategoryEnhance> categoryList() {
        //先从Redis查询
        String categoryString = (String) template.boundValueOps("category").get();
        //有则直接返回
        if(categoryString != null) return JSON.parseArray(categoryString, CategoryEnhance.class);
        //没有就从数据库查询
        List<CategoryEnhance> categoryEnhances = categoryMapper.selectSubcategory(0);
        if(categoryEnhances == null) return null;
        //数据库也没有就返回空
        template.boundValueOps("category").set(JSON.toJSONString(categoryEnhances));
        //有则存入Redis
        return categoryEnhances;
        //返回数据
    }
}
