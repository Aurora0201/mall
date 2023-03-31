package top.pi1grim.mall.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import top.pi1grim.mall.dto.IndexImgDTO;
import top.pi1grim.mall.entity.IndexImg;
import top.pi1grim.mall.mapper.IndexImgMapper;
import top.pi1grim.mall.service.IndexImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
    @Resource
    private StringRedisTemplate template;
    @Override
    public List<IndexImgDTO> getListOrderByDesc() {
        //先从Redis查询
        String indexImgString = (String) template.boundValueOps("indexImg").get();
        //有则返回
        if(indexImgString != null) return JSON.parseArray(indexImgString, IndexImgDTO.class);
        //没有就从数据库查询
        List<IndexImg> indexImg = indexImgMapper.selectList(new LambdaQueryWrapper<IndexImg>()
                .eq(IndexImg::getStatus, 1)
                .orderByDesc(IndexImg::getSeq));
        //数据库没有说明不存在
        if(indexImg == null) return null;
        //有就转换为DTO对象并存入Redis中
        List<IndexImgDTO> indexImgDTO = indexImg.stream()
                .map(img -> IndexImgDTO.builder()
                        .imgUrl(img.getImgUrl())
                        .imgBgColor(img.getImgBgColor())
                        .build()).toList();
        template.boundValueOps("indexImg").set(JSON.toJSONString(indexImgDTO));
        return indexImgDTO;
    }
}
