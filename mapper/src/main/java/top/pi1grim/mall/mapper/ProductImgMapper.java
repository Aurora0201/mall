package top.pi1grim.mall.mapper;

import top.pi1grim.mall.entity.ProductImg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品图片  Mapper 接口
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
public interface ProductImgMapper extends BaseMapper<ProductImg> {
    List<ProductImg> selectProductImgById(int productId);
}
