package top.pi1grim.mall.service.impl;

import top.pi1grim.mall.entity.Orders;
import top.pi1grim.mall.mapper.OrdersMapper;
import top.pi1grim.mall.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单  服务实现类
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

}
