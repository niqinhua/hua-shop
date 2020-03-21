package com.hua.shop.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.shop.gmall.core.bean.PageVo;
import com.hua.shop.gmall.core.bean.Query;
import com.hua.shop.gmall.core.bean.QueryCondition;

import com.hua.shop.sms.dao.SpuBoundsDao;
import com.hua.shop.sms.entity.SpuBoundsEntity;
import com.hua.shop.sms.service.SpuBoundsService;


@Service("spuBoundsService")
public class SpuBoundsServiceImpl extends ServiceImpl<SpuBoundsDao, SpuBoundsEntity> implements SpuBoundsService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SpuBoundsEntity> page = this.page(
                new Query<SpuBoundsEntity>().getPage(params),
                new QueryWrapper<SpuBoundsEntity>()
        );

        return new PageVo(page);
    }

}