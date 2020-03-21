package com.hua.shop.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.shop.gmall.core.bean.PageVo;
import com.hua.shop.gmall.core.bean.QueryCondition;
import com.hua.shop.pms.entity.CommentReplayEntity;


/**
 * 商品评价回复关系
 *
 * @author 倪勤华
 * @date 2020-03-19 01:00:07
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageVo queryPage(QueryCondition params);
}

