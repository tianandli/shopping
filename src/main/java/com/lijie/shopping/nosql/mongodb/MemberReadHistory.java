package com.lijie.shopping.nosql.mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 功能描述：用户商品浏览历史记录的文档记录，因为要加入到mongodb，所以要封装一个文档类。
 * 文档对象的ID域添加@Id注解，需要检索的字段添加@Indexed注解
 *
 * @author: lijie
 * @date: 2021/5/31 16:52
 * @version: V1.0
 */
@Document
@Data
public class MemberReadHistory {
    @Id
    private String id;
    @Indexed
    private Long memberId;
    private String memberNickname;
    private String memberIcon;
    @Indexed
    private Long productId;
    private String productName;
    private String productPic;
    private String productSubTitle;
    private String productPrice;
    private Date createTime;
}

