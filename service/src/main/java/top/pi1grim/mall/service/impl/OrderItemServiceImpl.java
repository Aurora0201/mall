package top.pi1grim.mall.service.impl;

import top.pi1grim.mall.entity.OrderItem;
import top.pi1grim.mall.mapper.OrderItemMapper;
import top.pi1grim.mall.service.OrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单项/快照  服务实现类
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}
