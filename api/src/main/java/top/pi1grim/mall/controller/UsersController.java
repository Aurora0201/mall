package top.pi1grim.mall.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import top.pi1grim.mall.dto.UserDTO;
import top.pi1grim.mall.entity.Users;
import top.pi1grim.mall.service.UsersService;
import top.pi1grim.mall.type.UserStatus;
import top.pi1grim.mall.util.JwtUtil;
import top.pi1grim.mall.vo.ResultVO;

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
    public ResultVO login(String username, String password) {
        Users user = usersService.getOne(new QueryWrapper<Users>().eq("username", username));
        int code;
        if(user == null)code = 10;
        else code = user.getPassword().equals(password) ? 20 : 15;

        if(code == 20){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", user.getUsername());
            jsonObject.put("token", JwtUtil.getToken(user));
            return ResultVO.getRetVOByCode(code, jsonObject, UserStatus.class);
        }
        return ResultVO.getRetVOByCode(code, null, UserStatus.class);
    }

    @PostMapping("/register")
    public ResultVO register(@RequestBody UserDTO user) {
        String username = user.getUsername();
        String password = user.getPassword();
        int code = usersService.getOne(new QueryWrapper<Users>().eq("username", username)) != null? 30: 35;
        Users newUser = null;
        if(code == 35){
            newUser = new Users(username, password);
            usersService.save(newUser);
        }
        return ResultVO.getRetVOByCode(code, newUser, UserStatus.class);
    }
}
