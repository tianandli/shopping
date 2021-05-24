package com.lijie.shopping.modules.service.impl;

import com.lijie.shopping.modules.model.PmsProductCategoryAttributeRelation;
import com.lijie.shopping.modules.mapper.PmsProductCategoryAttributeRelationMapper;
import com.lijie.shopping.modules.service.PmsProductCategoryAttributeRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类） 服务实现类
 * </p>
 *
 * @author lijie
 * @since 2021-05-13
 */
@Service
public class PmsProductCategoryAttributeRelationServiceImpl extends ServiceImpl<PmsProductCategoryAttributeRelationMapper, PmsProductCategoryAttributeRelation> implements PmsProductCategoryAttributeRelationService {

}
