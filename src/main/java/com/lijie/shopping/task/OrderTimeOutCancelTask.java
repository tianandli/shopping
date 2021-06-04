//package com.lijie.shopping.task;
//
//import com.lijie.shopping.modules.service.OmsPortalOrderService;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
// * 功能描述：
// *
// * @author: lijie
// * @date: 2021/5/13 18:08
// * @version: V1.0
// */
//@Component
//@Slf4j
//public class OrderTimeOutCancelTask {
//    @Autowired
//    private OmsPortalOrderService portalOrderService;
//
//    /**
//     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
//     * 每1分钟扫描一次，
//     */
//    @Scheduled(cron = "0 0/1 * ? * ?")
//    private void cancelTimeOutOrder() {
//        log.info("定时任务跑了一遍========>");
//        Integer count = portalOrderService.cancelTimeOutOrder();
//        log.info("取消订单，并根据sku编号释放锁定库存，取消订单数量：{}",count);
//
//    }
//}
