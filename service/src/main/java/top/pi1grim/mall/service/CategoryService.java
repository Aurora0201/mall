package top.pi1grim.mall.service;

import top.pi1grim.mall.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import top.pi1grim.mall.entity.enhance.CategoryEnhance;

import java.util.List;

/**
 * <p>
 * 商品分类 服务类
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
public interface CategoryService extends IService<Category> {
    List<CategoryEnhance> categoryList();
}
