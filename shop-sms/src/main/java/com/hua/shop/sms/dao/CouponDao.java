package com.hua.shop.sms.dao;

import com.hua.shop.sms.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author 倪勤华
 * @date 2020-03-21 13:09:50
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
