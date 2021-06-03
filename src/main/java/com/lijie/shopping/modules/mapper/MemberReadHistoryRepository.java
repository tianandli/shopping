package com.lijie.shopping.modules.mapper;

import com.lijie.shopping.nosql.mongodb.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 功能描述：会员商品浏览历史Repository
 * 添加MemberReadHistoryRepository接口用于操作Mongodb，
 * 继承MongoRepository接口，这样就拥有了一些基本的Mongodb数据操作方法，同时定义了一个衍生查询方法。
 *
 * @author: lijie
 * @date: 2021/5/31 16:58
 * @version: V1.0
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {
    /**
     * 根据会员id按时间倒序获取浏览记录 (这里只需要打名字就会有对应的方法出来)
     * @param memberId 会员id
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}
