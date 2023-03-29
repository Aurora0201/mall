package top.pi1grim.mall.vo;

import lombok.Builder;
import lombok.Data;
import top.pi1grim.mall.type.GenericEnum;
import top.pi1grim.mall.type.UserStatus;
import top.pi1grim.mall.util.EnumUtil;

@Data
@Builder
public class ResultVO {
    private int code;
    private String message;
    private Object data;
    public static ResultVO getRetVOByCode(int code, Object data, Class<? extends GenericEnum> enumClass) {
        GenericEnum status = EnumUtil.getEnumByCode(code, enumClass);
        return builder().code(status.getCode())
                .message(status.getMessage())
                .data(data)
                .build();
    }
}
