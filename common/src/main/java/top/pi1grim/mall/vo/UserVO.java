package top.pi1grim.mall.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import top.pi1grim.mall.type.UserStatus;
import top.pi1grim.mall.util.EnumUtil;

@Data
@Builder
@Schema(name = "响应对象",description = "包含响应给前端的信息")
public class UserVO {
    @Schema(name = "响应码", description = "20表示成功")
    private int code;
    private String msg;
    private Object data;

    public static UserVO getRetVOByCode(int code, Object data) {
        UserStatus status = EnumUtil.getEnumByCode(code, UserStatus.class);
        return builder().code(status.getCode())
                .msg(status.getMessage())
                .data(data)
                .build();
    }
}
