package top.pi1grim.mall.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryStatus implements GenericEnum{
    FAIL(10, "获取列表数据失败"),
    GET_LIST(15, "获取分类列表成功");

    private final int code;
    private final String message;
}
