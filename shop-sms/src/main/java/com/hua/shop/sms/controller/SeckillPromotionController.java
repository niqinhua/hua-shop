package com.hua.shop.sms.controller;

import java.util.Arrays;
import java.util.Map;


import com.hua.shop.gmall.core.bean.PageVo;
import com.hua.shop.gmall.core.bean.QueryCondition;
import com.hua.shop.gmall.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hua.shop.sms.entity.SeckillPromotionEntity;
import com.hua.shop.sms.service.SeckillPromotionService;




/**
 * 秒杀活动
 *
 * @author 倪勤华
 * @date 2020-03-21 13:09:50
 */
@Api(tags = "秒杀活动 管理")
@RestController
@RequestMapping("sms/seckillpromotion")
public class SeckillPromotionController {
    @Autowired
    private SeckillPromotionService seckillPromotionService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/page")
    @PreAuthorize("hasAuthority('sms:seckillpromotion:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = seckillPromotionService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('sms:seckillpromotion:info')")
    public Resp<SeckillPromotionEntity> info(@PathVariable("id") Long id){
		SeckillPromotionEntity seckillPromotion = seckillPromotionService.getById(id);

        return Resp.ok(seckillPromotion);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('sms:seckillpromotion:save')")
    public Resp<Object> save(@RequestBody SeckillPromotionEntity seckillPromotion){
		seckillPromotionService.save(seckillPromotion);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PutMapping
    @PreAuthorize("hasAuthority('sms:seckillpromotion:update')")
    public Resp<Object> update(@RequestBody SeckillPromotionEntity seckillPromotion){
		seckillPromotionService.updateById(seckillPromotion);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @DeleteMapping
    @PreAuthorize("hasAuthority('sms:seckillpromotion:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		seckillPromotionService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
