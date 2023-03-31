package top.pi1grim.mall.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IndexImgStatus implements GenericEnum{
    FAIL(10, "获取数据失败"),
    GET_BANNER(15, "获取轮播图成功");

    private final int code;
    private final String message;
}
