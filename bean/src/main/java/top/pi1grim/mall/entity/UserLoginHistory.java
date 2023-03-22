package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 登录历史表 
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
@Getter
@Setter
@Data
@TableName("user_login_history")
public class UserLoginHistory {

    /**
     * ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 地区
     */
    private String area;

    /**
     * 国家
     */
    private String country;

    /**
     * 用户id
     */
    private String userId;

    /**
     * IP
     */
    private String ip;

    /**
     * 时间
     */
    private String loginTime;
}
