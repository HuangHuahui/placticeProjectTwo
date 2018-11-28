package org.basedata.word.pro.build;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Swagger 是一款RESTFUL接口的文档在线自动生成+功能测试功能软件。
//用@Configuration注解该类，等价于XML中配置beans；用@Bean标注方法等价于XML中配置bean。
//swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
/**
 * Swagger 配置类(与Spring boot 整合，该配置类与Spring boot启动类放在同一级别)<br/>
 * 访问地址：http://localhost:11270/swagger-ui.html
 * @author: hhh 
 * @date:   2018年5月25日 上午10:55:49 
 * @version: V1.0
 */
@Configuration 
@EnableSwagger2  //加上注解@EnableSwagger2 表示开启Swagger
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("org.basedata.word.pro.build.api"))
                .paths(PathSelectors.any())
                .build();
    }
    
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Spring Boot 测试使用 Swagger2 构建RESTful API")
                //创建人
                .contact(new Contact("hhh", "http://www.baidu.com", ""))
                //版本号
                .version("1.0")
                //描述
                .description("数据库设计")
                .build();
    }
    
    /*
     * 使用参数说明 
        1. Api：修饰整个类，描述Controller的作用 
        2. ApiOperation：描述一个类的一个方法，或者说一个接口 
        3. ApiParam：单个参数描述 
        4. ApiModel：用对象来接收参数 
        5. ApiProperty：用对象接收参数时，描述对象的一个字段 
        6. ApiImplicitParams、ApiImplicitParam：描述接口参数 
        7. ApiModel：传递复杂对象定义 
        8. ApiResponse：HTTP响应其中1个描述 
        9. ApiResponses：HTTP响应整体描述
        
        注意：ApiImplicitParam 和 ApiParam 区别 
        1.对Servlets或者非 JAX-RS的环境，只能使用 ApiImplicitParam。 
        2.在使用上，ApiImplicitParam比ApiParam具有更少的代码侵入性，只要写在方法上就可以了，但是需要提供具体的属性才能配合swagger ui解析使用。 
        3.ApiParam只需要较少的属性，与swagger ui配合更好
        
        常用注解： 
        - @Api()用于类； 
        表示标识这个类是swagger的资源 
        - @ApiOperation()用于方法； 
        表示一个http请求的操作 
        - @ApiParam()用于方法，参数，字段说明； 
        表示对参数的添加元数据（说明或是否必填等） 
        - @ApiModel()用于类 
        表示对类进行说明，用于参数用实体类接收 
        - @ApiModelProperty()用于方法，字段 
        表示对model属性的说明或者数据操作更改 
        - @ApiIgnore()用于类，方法，方法参数 
        表示这个方法或者类被忽略 
        - @ApiImplicitParam() 用于方法 
        表示单独的请求参数 
        - @ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam
        
        具体使用举例说明： 
        @Api() 
        用于类；表示标识这个类是swagger的资源 
        tags–表示说明 
        value–也是说明，可以使用tags替代
     */
    
}
