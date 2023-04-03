# 商城实战项目

## 搭建项目Maven结构

![mall-hierarchy.drawio](https://cdn.jsdelivr.net/gh/Aurora0201/ImageStore@main/img/upgit_20230321_1679374260.png)

## 依赖分析

**common**

+ lombok的依赖

**bean**

+ lombok的依赖

**mapper**

+ spring-boot-starter的依赖
+ mybatis的依赖
+ mysql-connector的依赖
+ druid-starter的依赖
+ bean的依赖

**service**

+ mapper的依赖
+ common的依赖

**api**

+ service的依赖
+ spring-boot-starter-web的依赖
+ spring-boot-starter-test的依赖
+ 

## 软件开发步骤

+ 问题定义/提出问题
+ 可⾏性分析（技术、成本、法律法规）
+ 需求分析（需求采集、需求分析）---->甲⽅
+ 概要设计
    + 架构设计（技术选型、架构模式、项⽬搭建）
    + 数据库设计
    + UI设计
    + 业务流程设计
+ 详细设计
    + 实现步骤（业务流程的实现细节）
+ 编码
    + 根据设计好的实现步骤进⾏代码实现
    + 开发过程中开发者要进⾏单元测试
+ 测试
    + 集成测试
    + 功能测试（⿊盒）
    + 性能测试（⽩盒）
+ 交付/部署实施



## 导入数据库表

导入mall.sql文件



## 业务功能设计

### 用户系统

用户系统需要有下面的功能

+ 用户注册
+ 用户登录
+ 退出登录
+ 日志管理
+ 单点登录

![user_login.drawio](https://cdn.jsdelivr.net/gh/Aurora0201/ImageStore@main/img/upgit_20230321_1679400038.png)

**用户登录和用户注册**

使用枚举类储存所有的状态，通过Service层提供的CRUD接口即可完成，两个功能的实现



**登录验证**

在访问购物车和我的信息等页面需要用户登录才能获得数据，但是因为本项目是前后端分离项目，无法使用单体项目中的session，所以这里我们使用JWT来进行登录的验证

+ token生成：提供JWT工具类来生成Token
+ 设置拦截器：在访问敏感资源时拦截并验证token，过滤不合法的token
+ token存储：登录成功后在sessionStorage存储token



### 首页功能

**轮播图的获取**

轮播图的信息存储在数据库中，我们需要从数据库中获取轮播图的信息然后展示在首页上

+ 数据库的查询：简单的单表查询返回List
+ 前端的渲染：通过ajax请求到数据后，通过在标签绑定列表渲染，**在数据挂载后再执行轮播的JS代码**



**分类列表的获取**

分类列表的信息存储在数据库中，通过level字段来区分分类的层级，通过parent_id来指向父级分类

+ 数据存储结构：提供CategoryEnhance类，增强字段`List<CategoryEnhance>`
+ 数据库表查询：根据parent_id查询分类，首先通过*parent_id = 0*查询查出一级分类的字段，通过分布查询递归调用查询
+ 前端数据渲染：获得后端数据后，通过分级绑定列表渲染，在数据挂载后执行分类JS代码



**商品推荐**

根据商品上新时间获取商品推荐

+ 存储数据结构：提供ProductEnhance类，增强字段`List<ProductImg>`
+ 数据库表查询：使用分步查询，先查出最新的三个商品，在根据商品id分步查询出商品的图片



### 商品系统

**详情页面**

用户点击商品图片跳转到详情页面后，我们需要通过向后端传入商品Id来获取对应商品的信息，动态的渲染页面，首先看上面的面板：

+ 左边的部分，是略缩图和细节图
+ 右边是商品的标题，还有SKU的信息

这里就涉及了三表的查询，通过productId来查询对应商品的信息，这里我们的解决方案是提供一个DTO对象`ProductDetailDTO`，有三个字段：

+ `Product`
+ `List<ProductImg>`
+ `List<ProductSku>`



**商品详细参数**

用户通过滚轮往下滑时，向后端请求商品的详细参数信息，只涉及单表的查询，直接实现即可



## 使用JWT实现用户登录验证

### JWT使用场景

用户在访问首页，商品资源时，无需进行用户验证，但是当用户想要将商品添加到购物车，发布评论时，需要登录账号才能继续操作，这种需要登录才能访问的资源称为受限资源，在前后端分离的项目中我们无法再使用session来存储一个用户登录的信息，这时就轮到JWT登场了

![JWT.drawio](https://cdn.jsdelivr.net/gh/Aurora0201/ImageStore@main/img/upgit_20230403_1680528959.png)

### 使用JWT实现登录验证

先引入依赖，这里选择的是jjwt，在service层中引入

```xml
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.11.5</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId> <!-- or jjwt-gson if Gson is preferred -->
    <version>0.11.5</version>
    <scope>runtime</scope>
</dependency>
```

编写一个Token工具类，用来提供token

```java
package top.pi1grim.mall.util;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import top.pi1grim.mall.entity.Users;

import java.security.Key;
import java.util.Date;

public class JwtUtil {
    public static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String getToken(Users user) {
        if(user == null) return null;

        return Jwts.builder()
                .signWith(KEY)
                .setId(String.valueOf(user.getUserId()))
                .setIssuer("Bin")
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .setSubject("Login")
                .compact();
    }
}
```

编写拦截器，对于访问敏感资源的请求进行拦截，token合法则运行访问

```java
package top.pi1grim.mall.interceptor;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.pi1grim.mall.type.TokenStatus;
import top.pi1grim.mall.util.JwtUtil;
import top.pi1grim.mall.vo.VO;

import java.io.IOException;


@Component
public class CheckTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        //跳过OPTIONS
        if("OPTIONS".equals(request.getMethod()))return true;
        //校验Token
        String token = request.getHeader("token");
        try {
            if (token == null)throw new JwtException("Token为空");
            Jwts.parserBuilder()
                    .setSigningKey(JwtUtil.KEY)
                    .build()
                    .parseClaimsJws(token);
            //通过了
            return true;
        } catch (JwtException e) {
            response.setContentType("application/json;charset=utf-8");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("interceptor", VO.getRetVOByCode(10, "该请求已被拦截，请检查Token", TokenStatus.class));
            response.getWriter().print(jsonObject);
        }
        return false;
    }
}

```





## 使用Redis减轻数据库压力

### Redis使用场景

Redis缓存的数据一般来说有下面的特点：

+ 写的次数较少或者几乎不写，但是读的次数相当多的数据
+ 对于数据一致性要求较低，读次数较多的数据



### 使用Redis缓存数据

在业务层中使用Redis的流程：

+ 首先从Redis中拿
    + 如果有直接返回结果
    + 没有则向数据库查询
+ 在数据库查询获得结果
    + 如果没有就是不存在所需的数据，返回空
    + 如果有，就存入Redis中，返回结果

![redis-mysql.drawio](https://cdn.jsdelivr.net/gh/Aurora0201/ImageStore@main/img/upgit_20230403_1680529952.png)

