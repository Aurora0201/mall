package top.pi1grim.mall.service;

import top.pi1grim.mall.dto.IndexImgDTO;
import top.pi1grim.mall.entity.IndexImg;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 轮播图  服务类
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
public interface IndexImgService extends IService<IndexImg> {
    List<IndexImgDTO> getListOrderByDesc();
}
