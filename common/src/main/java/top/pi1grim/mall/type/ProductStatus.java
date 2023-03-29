package top.pi1grim.mall.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductStatus implements GenericEnum{
    OK(10, "获取产品列表成功"),
    FAIL(15, "获取产品列表失败");
    private final int code;
    private final String message;
}
