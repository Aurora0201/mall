package top.pi1grim.mall.util;

import top.pi1grim.mall.type.GenericEnum;

import java.util.Arrays;

public class EnumUtil {
    public static <T extends GenericEnum> T getEnumByCode(int code, Class<T> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(t -> t.getCode() == code)
                .findFirst()
                .orElse(null);
    }
}
