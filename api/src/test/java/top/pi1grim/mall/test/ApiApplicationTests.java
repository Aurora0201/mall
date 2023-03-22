package top.pi1grim.mall.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.pi1grim.mall.entity.Users;
import top.pi1grim.mall.mapper.UsersMapper;
import top.pi1grim.mall.service.UsersService;

import java.util.List;

@SpringBootTest
class ApiApplicationTests {

	@Resource
	private UsersService usersService;

	@Test
	void query() {
		QueryWrapper queryWrapper = new QueryWrapper<>(new Users());
		queryWrapper.eq("username", "aaaa");
		System.out.println(usersService.getOne(queryWrapper));
	}

	@Test
	void insert() {

	}

	@Test
	void remove() {
		QueryWrapper queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username","tom123123");
		usersService.remove(queryWrapper);
	}
}
