package top.pi1grim.mall.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 订单项/快照 
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
@Data
@Getter
@Setter
@TableName("order_item")
public class OrderItem {

    /**
     * 订单项ID
     */
    private String itemId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品图片
     */
    private String productImg;

    /**
     * skuID
     */
    private String skuId;

    /**
     * sku名称
     */
    private String skuName;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 购买数量
     */
    private Integer buyCounts;

    /**
     * 商品总金额
     */
    private BigDecimal totalAmount;

    /**
     * 加入购物车时间
     */
    private LocalDateTime basketDate;

    /**
     * 购买时间
     */
    private LocalDateTime buyTime;

    /**
     * 评论状态： 0 未评价  1 已评价
     */
    private Integer isComment;
}
