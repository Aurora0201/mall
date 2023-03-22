package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 用户 
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
@Getter
@Setter
@Data
public class Users {

    /**
     * 主键id 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名 用户名
     */
    private String username;

    /**
     * 密码 密码
     */
    private String password;

    /**
     * 昵称 昵称
     */
    private String nickname;

    /**
     * 真实姓名 真实姓名
     */
    private String realName;

    /**
     * 头像 头像
     */
    private String userImg;

    /**
     * 手机号 手机号
     */
    private String userMobile;

    /**
     * 邮箱地址 邮箱地址
     */
    private String userEmail;

    /**
     * 性别 M(男) or F(女)
     */
    private String userSex;

    /**
     * 生日 生日
     */
    private LocalDate userBirth;

    /**
     * 注册时间 创建时间
     */
    private LocalDateTime userRegtime;

    /**
     * 更新时间 更新时间
     */
    private LocalDateTime userModtime;
}
