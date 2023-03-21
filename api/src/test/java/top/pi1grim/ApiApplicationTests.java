package top.pi1grim;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.pi1grim.mall.dao.UserDAO;

@SpringBootTest
class ApiApplicationTests {

	@Resource
	private UserDAO userDAO;

	@Test
	void selectByName() {
		System.out.println(userDAO.selectByName("zhangsan"));
	}
}
