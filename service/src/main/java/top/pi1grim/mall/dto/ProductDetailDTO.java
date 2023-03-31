package top.pi1grim.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.pi1grim.mall.entity.Product;
import top.pi1grim.mall.entity.ProductImg;
import top.pi1grim.mall.entity.ProductSku;

import java.util.List;

@Data
@Builder
public class ProductDetailDTO {
    private Product product;
    private List<ProductImg> productImgs;
    private List<ProductSku> productSkus;
}
