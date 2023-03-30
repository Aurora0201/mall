package top.pi1grim.mall.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductStatus implements GenericEnum{
    OK(10, "获取产品列表成功"),
    FAIL(15, "失败"),
    GET_DETAIL(20, "获取商品详情成功"),
    GET_PARAM(25, "获取商品详情参数成功");
    private final int code;
    private final String message;
}
