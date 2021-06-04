package com.lijie.shopping.modules.service.impl;

import com.lijie.shopping.modules.model.OmsOrderItem;
import com.lijie.shopping.modules.mapper.OmsOrderItemMapper;
import com.lijie.shopping.modules.service.OmsOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单中所包含的商品 服务实现类
 * </p>
 *
 * @author lijie
 * @since 2021-06-04
 */
@Service
public class OmsOrderItemServiceImpl extends ServiceImpl<OmsOrderItemMapper, OmsOrderItem> implements OmsOrderItemService {

}
