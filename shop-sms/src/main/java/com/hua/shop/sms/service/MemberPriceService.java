package com.hua.shop.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.shop.sms.entity.MemberPriceEntity;
import com.hua.shop.gmall.core.bean.PageVo;
import com.hua.shop.gmall.core.bean.QueryCondition;


/**
 * 商品会员价格
 *
 * @author 倪勤华
 * @date 2020-03-21 13:09:50
 */
public interface MemberPriceService extends IService<MemberPriceEntity> {

    PageVo queryPage(QueryCondition params);
}

