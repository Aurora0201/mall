package top.pi1grim.mall.service.impl;

import top.pi1grim.mall.entity.Users;
import top.pi1grim.mall.mapper.UsersMapper;
import top.pi1grim.mall.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户  服务实现类
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
