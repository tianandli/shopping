package com.lijie.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ShoppingApplication {

    public static void main(String[] args) {
        //在main方法里插入下面的代码以解决es的netty冲突问题
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(ShoppingApplication.class, args);
    }

}
