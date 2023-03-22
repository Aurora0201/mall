package top.pi1grim.mall.service.impl;

import top.pi1grim.mall.entity.UserLoginHistory;
import top.pi1grim.mall.mapper.UserLoginHistoryMapper;
import top.pi1grim.mall.service.UserLoginHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录历史表  服务实现类
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
@Service
public class UserLoginHistoryServiceImpl extends ServiceImpl<UserLoginHistoryMapper, UserLoginHistory> implements UserLoginHistoryService {

}
