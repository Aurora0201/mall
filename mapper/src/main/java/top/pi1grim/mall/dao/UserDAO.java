package top.pi1grim.mall.dao;

import top.pi1grim.mall.entity.User;

public interface UserDAO {
    User selectByName(String username);
}
