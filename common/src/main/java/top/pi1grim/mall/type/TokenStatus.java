package top.pi1grim.mall.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TokenStatus implements GenericEnum{
    ILLEGAL(10, "Token已过期或不可用"), OK(15, "Token验证成功");

    private final int code;
    private final String message;
}
