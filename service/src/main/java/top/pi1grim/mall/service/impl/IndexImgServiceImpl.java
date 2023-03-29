package top.pi1grim.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import top.pi1grim.mall.dto.IndexImgDTO;
import top.pi1grim.mall.entity.IndexImg;
import top.pi1grim.mall.mapper.IndexImgMapper;
import top.pi1grim.mall.service.IndexImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 轮播图  服务实现类
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
@Service
public class IndexImgServiceImpl extends ServiceImpl<IndexImgMapper, IndexImg> implements IndexImgService {
    @Resource
    private IndexImgMapper indexImgMapper;
    @Override
    public List<IndexImgDTO> getListOrderByDesc() {
        return indexImgMapper.selectList(
                new QueryWrapper<IndexImg>()
                        .orderByDesc("seq")
                        .eq("status", 1))
                .stream()
                .map(indexImg -> IndexImgDTO.builder().imgUrl(indexImg.getImgUrl()).build())
                .toList();
//        return indexImgMapper.selectList(new QueryWrapper<IndexImg>().orderByDesc("seq"));
    }
}
