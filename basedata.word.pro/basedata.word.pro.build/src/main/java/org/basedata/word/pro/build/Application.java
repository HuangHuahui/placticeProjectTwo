package org.basedata.word.pro.build;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot 启动类
 * @author: hhh 
 * @date:   2018年5月25日 下午4:55:51 
 * @version: V1.0
 */
@SpringBootApplication(scanBasePackages="org.basedata.word.pro.build")
@MapperScan("org.basedata.word.pro.build.*.mapper")  //mapper接口的路径 
public class Application {
    
    /** 引入日志，注意都是"org.slf4j"包下 */
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.debug("Application Start ...");
        logger.debug("This is a debug message");  
        logger.info("This is an info message");  
        logger.warn("This is a warn message");  
        logger.error("This is an error message"); 
        SpringApplication.run(Application.class, args);
    }
}

