package top.pi1grim.mall.entity.enhance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEnhance {
    /**
     * 主键 分类id主键
     */
    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;

    /**
     * 分类名称 分类名称
     */
    private String categoryName;

    /**
     * 分类层级 分类得类型，
     1:一级大分类
     2:二级分类
     3:三级小分类
     */
    private Integer categoryLevel;

    /**
     * 父层级id 父id 上一级依赖的id，1级分类则为0，二级三级分别依赖上一级
     */
    private Integer parentId;

    /**
     * 图标 logo
     */
    private String categoryIcon;

    /**
     * 口号
     */
    private String categorySlogan;

    /**
     * 分类图
     */
    private String categoryPic;

    /**
     * 背景颜色
     */
    private String categoryBgColor;


    private List<CategoryEnhance> subcategory;
}
