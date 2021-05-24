package com.lijie.shopping.nosql.Elasticsearch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 功能描述：商品ES操作类.继承ElasticsearchRepository接口，这样就拥有了一些基本的Elasticsearch数据操作方法，同时定义了一个衍生查询方法
 *
 * @author: lijie
 * @date: 2021/5/14 11:00
 * @version: V1.0
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct,Long> {

    /**
     * 搜索查询。
     *
     * @param name              商品名称
     * @param subTitle          商品标题
     * @param keywords          商品关键字
     * @param page              分页信息
     * @return
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page);

}
