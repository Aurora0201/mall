# Shopping Mall Practical Project

## 1.搭建项目Maven结构

![mall-hierarchy.drawio](https://cdn.jsdelivr.net/gh/Aurora0201/ImageStore@main/img/upgit_20230321_1679374260.png)

## 2.依赖分析

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

## 3.软件开发步骤

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



## 4.导入数据库表

导入mall.sql文件



## 5.业务功能设计

### 1.用户系统

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



### 2.首页轮播图

**轮播图的获取**

轮播图的信息存储在数据库中，我们需要从数据库中获取轮播图的信息然后展示在首页上
