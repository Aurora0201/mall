package top.pi1grim.mall.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus implements GenericEnum{

    NONEXISTENT(10, "账号不存在"), MISMATCH(15, "账号密码不匹配"), OK(20, "登录成功"), EMPTY(25, "空"),
    ALREADY_EXIST(30, "账号已经存在"), SUCCESS(35, "注册成功");
    private final int code;
    private final String message;

}
