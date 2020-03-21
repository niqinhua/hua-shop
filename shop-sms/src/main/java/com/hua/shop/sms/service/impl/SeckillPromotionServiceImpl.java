package com.hua.shop.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.shop.gmall.core.bean.PageVo;
import com.hua.shop.gmall.core.bean.Query;
import com.hua.shop.gmall.core.bean.QueryCondition;

import com.hua.shop.sms.dao.SeckillPromotionDao;
import com.hua.shop.sms.entity.SeckillPromotionEntity;
import com.hua.shop.sms.service.SeckillPromotionService;


@Service("seckillPromotionService")
public class SeckillPromotionServiceImpl extends ServiceImpl<SeckillPromotionDao, SeckillPromotionEntity> implements SeckillPromotionService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SeckillPromotionEntity> page = this.page(
                new Query<SeckillPromotionEntity>().getPage(params),
                new QueryWrapper<SeckillPromotionEntity>()
        );

        return new PageVo(page);
    }

}