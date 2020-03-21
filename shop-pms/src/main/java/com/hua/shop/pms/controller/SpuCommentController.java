package com.hua.shop.pms.controller;


import com.hua.shop.gmall.core.bean.PageVo;
import com.hua.shop.gmall.core.bean.QueryCondition;
import com.hua.shop.gmall.core.bean.Resp;
import com.hua.shop.pms.entity.SpuCommentEntity;
import com.hua.shop.pms.service.SpuCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 商品评价
 *
 * @author 倪勤华
 * @date 2020-03-19 01:00:07
 */
@Api(tags = "商品评价 管理")
@RestController
@RequestMapping("pms/spucomment")
public class SpuCommentController {
    @Autowired
    private SpuCommentService spuCommentService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/page")
    @PreAuthorize("hasAuthority('pms:spucomment:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = spuCommentService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('pms:spucomment:info')")
    public Resp<SpuCommentEntity> info(@PathVariable("id") Long id){
		SpuCommentEntity spuComment = spuCommentService.getById(id);

        return Resp.ok(spuComment);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping
    @PreAuthorize("hasAuthority('pms:spucomment:save')")
    public Resp<Object> save(@RequestBody SpuCommentEntity spuComment){
		spuCommentService.save(spuComment);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PutMapping
    @PreAuthorize("hasAuthority('pms:spucomment:update')")
    public Resp<Object> update(@RequestBody SpuCommentEntity spuComment){
		spuCommentService.updateById(spuComment);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @DeleteMapping
    @PreAuthorize("hasAuthority('pms:spucomment:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		spuCommentService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
