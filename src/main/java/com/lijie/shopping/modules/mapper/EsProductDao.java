package com.lijie.shopping.modules.mapper;

import com.lijie.shopping.nosql.Elasticsearch.EsProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 功能描述：
 *
 * @author: lijie
 * @date: 2021/5/14 11:19
 * @version: V1.0
 */
@Component
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
