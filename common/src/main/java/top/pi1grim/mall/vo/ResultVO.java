package top.pi1grim.mall.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "响应对象",description = "包含响应给前端的信息")
public class ResultVO {
    @Schema(name = "响应码", description = "10000表示成功")
    private int code;
    private String msg;
    private Object data;
}
