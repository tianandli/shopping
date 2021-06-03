package com.lijie.shopping.modules.service;

import com.lijie.shopping.nosql.mongodb.MemberReadHistory;

import java.util.List;

/**
 * 功能描述：会员浏览记录管理Service
 *
 * @author: lijie
 * @date: 2021/5/31 17:00
 * @version: V1.0
 */
public interface MemberReadHistoryService {
    /**
     * 生成浏览记录
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     */
    int delete(List<String> ids);

    /**
     * 获取用户浏览历史记录
     */
    List<MemberReadHistory> list(Long memberId);
}
