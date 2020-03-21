package com.hua.shop.pms.controller;

import com.hua.shop.gmall.core.bean.PageVo;
import com.hua.shop.gmall.core.bean.QueryCondition;
import com.hua.shop.gmall.core.bean.Resp;
import com.hua.shop.pms.entity.SpuInfoDescEntity;
import com.hua.shop.pms.service.SpuInfoDescService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;




/**
 * spu信息介绍
 *
 * @author 倪勤华
 * @date 2020-03-19 01:00:06
 */
@Api(tags = "spu信息介绍 管理")
@RestController
@RequestMapping("pms/spuinfodesc")
public class SpuInfoDescController {
    @Autowired
    private SpuInfoDescService spuInfoDescService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/page")
    @PreAuthorize("hasAuthority('pms:spuinfodesc:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = spuInfoDescService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/{spuId}")
    @PreAuthorize("hasAuthority('pms:spuinfodesc:info')")
    public Resp<SpuInfoDescEntity> info(@PathVariable("spuId") Long spuId){
		SpuInfoDescEntity spuInfoDesc = spuInfoDescService.getById(spuId);

        return Resp.ok(spuInfoDesc);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping
    @PreAuthorize("hasAuthority('pms:spuinfodesc:save')")
    public Resp<Object> save(@RequestBody SpuInfoDescEntity spuInfoDesc){
		spuInfoDescService.save(spuInfoDesc);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PutMapping
    @PreAuthorize("hasAuthority('pms:spuinfodesc:update')")
    public Resp<Object> update(@RequestBody SpuInfoDescEntity spuInfoDesc){
		spuInfoDescService.updateById(spuInfoDesc);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @DeleteMapping
    @PreAuthorize("hasAuthority('pms:spuinfodesc:delete')")
    public Resp<Object> delete(@RequestBody Long[] spuIds){
		spuInfoDescService.removeByIds(Arrays.asList(spuIds));

        return Resp.ok(null);
    }

}
