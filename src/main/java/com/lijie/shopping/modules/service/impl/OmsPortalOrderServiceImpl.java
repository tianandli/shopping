package com.lijie.shopping.modules.service.impl;

import com.lijie.shopping.common.CommonResult;
import com.lijie.shopping.modules.service.OmsPortalOrderService;
import com.lijie.shopping.mq.CancelOrderSender;
import com.lijie.shopping.mq.OrderParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 前台订单管理Service
 * Created by macro on 2018/8/30.
 */
@Service
@Slf4j
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public Integer cancelTimeOutOrder() {
        //todo 执行一系类取消订单操作，具体参考mall项目
        return 1;
    }

    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        //todo 执行一系类下单操作，具体参考mall项目
        log.info("下单开始===");
        //下单完成后开启一个延迟消息，用于当用户没有付款时取消订单（orderId应该在下单后生成）
        sendDelayMessageCancelOrder(11L);
        log.info("下单结束===");
        return CommonResult.success(null, "下单成功");
    }

    @Override
    public void cancelOrder(Long orderId) {
        //todo 执行一系类取消订单操作，具体参考mall项目
        log.info("模拟取消订单成功，取消的订单id是:{}",orderId);
    }

    private void sendDelayMessageCancelOrder(Long orderId) {
        //获取订单超时时间，假设为60分钟
        long delayTimes = 25 * 1000;
        //发送延迟消息
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }
}
