import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class Generator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mall", "root", "root1234")
                .globalConfig(builder -> {
                    builder.author("Bin JunKai") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("/home/binjunkai/mall/mapper/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("top.pi1grim.mall") // 设置父包名
//                            .moduleName("mapper") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "/home/binjunkai/mall/mapper/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("users,user_login_history,user_addr,shopping_cart,product_sku,product_params,product_img,product_comments,product,orders,order_item,index_img,category")
                            .entityBuilder()
                            .enableLombok()
                            .disableSerialVersionUID()
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .mapperBuilder()
                            .superClass(BaseMapper.class);//specify BaseMapper
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
