package com.hua.shop.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.shop.gmall.core.bean.PageVo;
import com.hua.shop.gmall.core.bean.Query;
import com.hua.shop.gmall.core.bean.QueryCondition;
import com.hua.shop.pms.dao.CommentReplayDao;
import com.hua.shop.pms.entity.CommentReplayEntity;
import com.hua.shop.pms.service.CommentReplayService;
import org.springframework.stereotype.Service;


@Service("commentReplayService")
public class CommentReplayServiceImpl extends ServiceImpl<CommentReplayDao, CommentReplayEntity> implements CommentReplayService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CommentReplayEntity> page = this.page(
                new Query<CommentReplayEntity>().getPage(params),
                new QueryWrapper<CommentReplayEntity>()
        );

        return new PageVo(page);
    }

}