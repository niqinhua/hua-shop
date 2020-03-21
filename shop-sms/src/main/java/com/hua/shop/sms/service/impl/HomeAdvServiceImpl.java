package com.hua.shop.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.shop.gmall.core.bean.PageVo;
import com.hua.shop.gmall.core.bean.Query;
import com.hua.shop.gmall.core.bean.QueryCondition;

import com.hua.shop.sms.dao.HomeAdvDao;
import com.hua.shop.sms.entity.HomeAdvEntity;
import com.hua.shop.sms.service.HomeAdvService;


@Service("homeAdvService")
public class HomeAdvServiceImpl extends ServiceImpl<HomeAdvDao, HomeAdvEntity> implements HomeAdvService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<HomeAdvEntity> page = this.page(
                new Query<HomeAdvEntity>().getPage(params),
                new QueryWrapper<HomeAdvEntity>()
        );

        return new PageVo(page);
    }

}