package top.pi1grim.mall.vo;

import lombok.Builder;
import lombok.Data;
import top.pi1grim.mall.type.UserStatus;
import top.pi1grim.mall.util.EnumUtil;

@Data
@Builder
public class ResultVO {
    private int code;
    private String message;
    private Object data;
    public static ResultVO getRetVOByCode(int code, Object data) {
        UserStatus status = EnumUtil.getEnumByCode(code, UserStatus.class);
        return builder().code(status.getCode())
                .message(status.getMessage())
                .data(data)
                .build();
    }
}
