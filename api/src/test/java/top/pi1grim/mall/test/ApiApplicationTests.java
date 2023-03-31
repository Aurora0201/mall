package top.pi1grim.mall.test;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import top.pi1grim.mall.dto.ProductDetailDTO;
import top.pi1grim.mall.entity.enhance.CategoryEnhance;
import top.pi1grim.mall.mapper.CategoryMapper;
import top.pi1grim.mall.mapper.ProductMapper;
import top.pi1grim.mall.service.IndexImgService;
import top.pi1grim.mall.service.ProductService;
import top.pi1grim.mall.service.UsersService;
import top.pi1grim.mall.type.TokenStatus;
import top.pi1grim.mall.type.UserStatus;
import top.pi1grim.mall.util.EnumUtil;

import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
class ApiApplicationTests {

	@Resource
	private UsersService usersService;

	@Test
	void query() {

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

	@Test
	void lambdaTest() throws UnsupportedEncodingException {
		String s = "123dashdligaasdui120oasd;nfasasdasaksdhkjlashd";
		byte[] bytes = s.getBytes("UTF-8");
		SecretKey key = Keys.hmacShaKeyFor(bytes); //or HS384 or HS512
		SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		String jws = Jwts.builder().setSubject("Bin").signWith(secretKey).compact();
		System.out.println(jws);

		try {

			Claims body = Optional.of(Jwts.parserBuilder().setSigningKey(Keys.secretKeyFor(SignatureAlgorithm.HS256)).build().parseClaimsJws(jws))
					.get().getBody();

			//OK, we can trust this JWT
			System.out.println(body);
		} catch (Exception e) {
			System.out.println("don't trust the JWT!");
			//don't trust the JWT!
		}
	}

	@Test
	void enumUtilTest() {
		System.out.println(EnumUtil.getEnumByCode(10, TokenStatus.class));
		System.out.println(EnumUtil.getEnumByCode(10, UserStatus.class));
	}

	@Resource
	IndexImgService indexImgService;
	@Test
	void imgTest() {
		System.out.println(indexImgService.getListOrderByDesc());
	}

	@Resource
	private CategoryMapper categoryMapper;
	@Test
	void selectTest() {
		List<CategoryEnhance> categoryEnhances = categoryMapper.selectSubcategory(0);
		System.out.println(categoryEnhances);
	}

	@Resource
	private ProductMapper productMapper;
	@Resource
	private ProductService productService;
	@Test
	void productTest() {
		productService.productDetail(3);
	}

	@Resource
	private StringRedisTemplate template;
	@Test
	void redisTest() {
		String productInfo = (String) template.boundHashOps("product").get(String.valueOf(3));
//		ProductDetailDTO product = JSON.parseObject(productInfo, ProductDetailDTO.class);
		System.out.println(productInfo);
	}


}
