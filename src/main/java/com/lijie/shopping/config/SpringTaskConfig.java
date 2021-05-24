package com.lijie.shopping.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 功能描述：定时任务配置
 *SpringTask已经存在于Spring框架中，所以无需添加依赖。只需要在配置类中添加一个@EnableScheduling注解即可开启SpringTask的定时任务能力。
 * @author: lijie
 * @date: 2021/5/13 18:07
 * @version: V1.0
 */
@Configuration
@EnableScheduling
public class SpringTaskConfig {
}
