package com.lijie.shopping.modules.service;

import com.lijie.shopping.common.CommonResult;
import com.lijie.shopping.mq.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前台订单管理Service
 * Created by macro on 2018/8/30.
 */
public interface OmsPortalOrderService {
    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * 自动取消超时订单
     */
    @Transactional
    Integer cancelTimeOutOrder();
}
