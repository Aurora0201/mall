package top.pi1grim.mall.entity;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
@Data
@Getter
@Setter
public class Product {

    /**
     * 商品主键id
     */
    private String productId;

    /**
     * 商品名称 商品名称
     */
    private String productName;

    /**
     * 分类外键id 分类id
     */
    private Integer categoryId;

    /**
     * 一级分类外键id 一级分类id，用于优化查询
     */
    private Integer rootCategoryId;

    /**
     * 销量 累计销售
     */
    private Integer soldNum;

    /**
     * 默认是1，表示正常状态, -1表示删除, 0下架 默认是1，表示正常状态, -1表示删除, 0下架
     */
    private Integer productStatus;

    /**
     * 商品内容 商品内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
