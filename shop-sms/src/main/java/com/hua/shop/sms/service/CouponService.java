package com.hua.shop.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hua.shop.sms.entity.CouponEntity;
import com.hua.shop.gmall.core.bean.PageVo;
import com.hua.shop.gmall.core.bean.QueryCondition;


/**
 * 优惠券信息
 *
 * @author 倪勤华
 * @date 2020-03-21 13:09:50
 */
public interface CouponService extends IService<CouponEntity> {

    PageVo queryPage(QueryCondition params);
}

