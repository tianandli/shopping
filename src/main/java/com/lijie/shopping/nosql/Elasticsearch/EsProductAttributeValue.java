package com.lijie.shopping.nosql.Elasticsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * 功能描述：从数据库查出来的数据可能包含Null字段，
 * 所以这个类上要加@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
 *
 * @author: lijie
 * @date: 2021/5/14 11:02
 * @version: V1.0
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class EsProductAttributeValue implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long productAttributeId;
    //属性值
    @Field(type = FieldType.Keyword)
    private String value;
    //属性参数：0->规格；1->参数
    private Integer type;
    //属性名称
    @Field(type=FieldType.Keyword)
    private String name;
}
