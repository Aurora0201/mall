package top.pi1grim.mall.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IndexImgDTO {
    private String imgUrl;
    private String imgBgColor;
}
