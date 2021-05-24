package com.lijie.shopping.nosql.Elasticsearch;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 功能描述：搜索中的商品属性信息
 * @Documnet注解的参数：
 * indexName：索引库的名称。type：类型。shards：默认分区数。replicas：每个分区默认的备份数。
 * refreshInterval：刷新间隔，默认1s。indexStoreType：索引文件存储类型，默认位fs
 * @Field注解的参数：
 *type：自动检测属性的类型，可以根据实际情况自己设置。
 *index：默认情况下分词，一般默认分词就好，除非这个字段你确定查询时不会用到
 *format：时间类型的格式化。store：默认情况下不存储原文。searchAnalyzer：指定字段搜索时使用的分词器。
 *indexAnalyzer：指定字段建立索引时指定的分词器。ignoreFields：如果某个字段需要被忽略
 * 中文分词简单理解就是一种提高检索精准度的一种技术。因为我们后边在接口中查询的时候主要是根据name，subTitle和keywords这三个字段查询的
 * 所以对这三个字段加上中文分词以提高查询的精准度：
 * 不需要中文分词的字段设置成@Field(type = FieldType.Keyword)类型，
 * 需要中文分词的设置成@Field(analyzer = "ik_max_word",type = FieldType.Text)类型。
 * @author: lijie
 * @date: 2021/5/14 10:59
 * @version: V1.0
 */
@Data
@Document(indexName = "pms", type= "product",shards = 1,replicas = 0)
public class EsProduct implements Serializable {
    private static final long serialVersionUID = -1L;
    @Id
    private Long id;
    @Field(type = FieldType.Keyword)
    private String productSn;
    private Long brandId;
    @Field(type = FieldType.Keyword)
    private String brandName;
    private Long productCategoryId;
    @Field(type = FieldType.Keyword)
    private String productCategoryName;
    private String pic;
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String name;
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String subTitle;
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String keywords;
    private BigDecimal price;
    private Integer sale;
    private Integer newStatus;
    private Integer recommandStatus;
    private Integer stock;
    private Integer promotionType;
    private Integer sort;
    @Field(type =FieldType.Nested)
    private List<EsProductAttributeValue> attrValueList;
}
