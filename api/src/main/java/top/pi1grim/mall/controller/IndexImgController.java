package top.pi1grim.mall.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.pi1grim.mall.dto.IndexImgDTO;
import top.pi1grim.mall.service.IndexImgService;
import top.pi1grim.mall.type.IndexImgStatus;
import top.pi1grim.mall.vo.VO;

import java.util.List;

/**
 * <p>
 * 轮播图  前端控制器
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
@RestController
@RequestMapping("/indexImg")
@CrossOrigin
public class IndexImgController {
    @Resource
    private IndexImgService indexImgService;
    @GetMapping("/banner")
    public VO banner() {
        List<IndexImgDTO> indexImg = indexImgService.getListOrderByDesc();
        return VO.getRetVOByCode(indexImg == null ? 10 : 15, indexImg, IndexImgStatus.class);
    }
}
