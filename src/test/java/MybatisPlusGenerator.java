import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;

/**
 * @Author: hape
 * @Date: 2022/9/29 15:08
 */
public class MybatisPlusGenerator {

    private static final String url = "jdbc:mysql://101.43.115.8:6033/hape_db?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&zeroDateTimeBehavior=convertToNull";
    private static final String username = "root";
    private static final String password = "ppxwmz";

    public static void main(String[] args) {
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("hape") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .dateType(DateType.ONLY_DATE);
                })
                .templateConfig(builder -> builder.controller(null))
                .packageConfig(builder -> {
                    builder.parent("com.hape.dao")// 设置父包名
                            .entity("web.po")
                            .mapper("web.mapper")
                            .xml("web.mapper")
                            .service("web.service")
                            .serviceImpl("web.service")
                            .other("other");
                })
                .strategyConfig(builder -> {
                    builder
//                            .addInclude("") // 设置需要生成的表名
                            .addTablePrefix("t_") // 设置过滤表前缀
//                            .likeTable(new LikeTable(""))
                            .entityBuilder()
                            .enableTableFieldAnnotation()
                            .enableLombok()
                            .fileOverride()
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                            .addTableFills(new Property("update_time", FieldFill.INSERT_UPDATE))
                            .formatFileName("%sPO")
                            .idType(IdType.AUTO)
                            .serviceBuilder()
                            .fileOverride()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .mapperBuilder()
                            .formatMapperFileName("%sMapper")
                            .formatXmlFileName("%sMapper")
                            .build();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
