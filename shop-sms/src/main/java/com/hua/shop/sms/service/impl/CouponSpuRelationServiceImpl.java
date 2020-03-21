package com.hua.shop.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.shop.gmall.core.bean.PageVo;
import com.hua.shop.gmall.core.bean.Query;
import com.hua.shop.gmall.core.bean.QueryCondition;

import com.hua.shop.sms.dao.CouponSpuRelationDao;
import com.hua.shop.sms.entity.CouponSpuRelationEntity;
import com.hua.shop.sms.service.CouponSpuRelationService;


@Service("couponSpuRelationService")
public class CouponSpuRelationServiceImpl extends ServiceImpl<CouponSpuRelationDao, CouponSpuRelationEntity> implements CouponSpuRelationService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CouponSpuRelationEntity> page = this.page(
                new Query<CouponSpuRelationEntity>().getPage(params),
                new QueryWrapper<CouponSpuRelationEntity>()
        );

        return new PageVo(page);
    }

}