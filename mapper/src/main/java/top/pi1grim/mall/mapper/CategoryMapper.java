package top.pi1grim.mall.mapper;

import top.pi1grim.mall.entity.enhance.CategoryEnhance;
import top.pi1grim.mall.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品分类 Mapper 接口
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
public interface CategoryMapper extends BaseMapper<Category> {
    List<CategoryEnhance> selectCategory();

    List<CategoryEnhance> selectSubcategory(int parentId);
}
