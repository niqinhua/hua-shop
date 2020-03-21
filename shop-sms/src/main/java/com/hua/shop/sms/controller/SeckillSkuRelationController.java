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

import com.hua.shop.sms.entity.SeckillSkuRelationEntity;
import com.hua.shop.sms.service.SeckillSkuRelationService;




/**
 * 秒杀活动商品关联
 *
 * @author 倪勤华
 * @date 2020-03-21 13:09:50
 */
@Api(tags = "秒杀活动商品关联 管理")
@RestController
@RequestMapping("sms/seckillskurelation")
public class SeckillSkuRelationController {
    @Autowired
    private SeckillSkuRelationService seckillSkuRelationService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/page")
    @PreAuthorize("hasAuthority('sms:seckillskurelation:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = seckillSkuRelationService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('sms:seckillskurelation:info')")
    public Resp<SeckillSkuRelationEntity> info(@PathVariable("id") Long id){
		SeckillSkuRelationEntity seckillSkuRelation = seckillSkuRelationService.getById(id);

        return Resp.ok(seckillSkuRelation);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('sms:seckillskurelation:save')")
    public Resp<Object> save(@RequestBody SeckillSkuRelationEntity seckillSkuRelation){
		seckillSkuRelationService.save(seckillSkuRelation);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PutMapping
    @PreAuthorize("hasAuthority('sms:seckillskurelation:update')")
    public Resp<Object> update(@RequestBody SeckillSkuRelationEntity seckillSkuRelation){
		seckillSkuRelationService.updateById(seckillSkuRelation);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @DeleteMapping
    @PreAuthorize("hasAuthority('sms:seckillskurelation:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		seckillSkuRelationService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
