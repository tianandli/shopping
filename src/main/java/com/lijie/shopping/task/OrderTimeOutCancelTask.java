package com.lijie.shopping.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 功能描述：
 *
 * @author: lijie
 * @date: 2021/5/13 18:08
 * @version: V1.0
 */
@Component
@Slf4j
public class OrderTimeOutCancelTask {
    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * 每1分钟扫描一次，
     */
    @Scheduled(cron = "0 0/1 * ? * ?")
    private void cancelTimeOutOrder() {
        log.info("定时任务跑了一遍========>");
    }
}
