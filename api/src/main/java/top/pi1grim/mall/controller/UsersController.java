package top.pi1grim.mall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import top.pi1grim.mall.dto.User;
import top.pi1grim.mall.entity.Users;
import top.pi1grim.mall.service.UsersService;
import top.pi1grim.mall.util.JwtUtil;
import top.pi1grim.mall.vo.UserVO;

/**
 * <p>
 * 用户  前端控制器
 * </p>
 *
 * @author Bin JunKai
 * @since 2023-03-22
 */
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UsersController {
    @Resource
    UsersService usersService;
    @GetMapping("/login")
    public UserVO login(String username, String password) {
        Users user = usersService.getOne(new QueryWrapper<Users>().eq("username", username));
        int code;
        if(user == null)code = 10;
        else code = user.getPassword().equals(password) ? 20 : 15;
        if(code != 20) user = null;
        return UserVO.getRetVOByCode(code, JwtUtil.getToken(user));
    }

    @PostMapping("/register")
    public UserVO register(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        int code = usersService.getOne(new QueryWrapper<Users>().eq("username", username)) != null? 30: 35;
        Users newUser = null;
        if(code == 35){
            newUser = new Users(username, password);
            usersService.save(newUser);
        }
        return UserVO.getRetVOByCode(code, newUser);
    }
}
