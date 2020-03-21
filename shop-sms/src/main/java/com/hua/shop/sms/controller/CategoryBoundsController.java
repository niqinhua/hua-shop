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

import com.hua.shop.sms.entity.CategoryBoundsEntity;
import com.hua.shop.sms.service.CategoryBoundsService;




/**
 * 商品分类积分设置
 *
 * @author 倪勤华
 * @date 2020-03-21 13:09:50
 */
@Api(tags = "商品分类积分设置 管理")
@RestController
@RequestMapping("sms/categorybounds")
public class CategoryBoundsController {
    @Autowired
    private CategoryBoundsService categoryBoundsService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/page")
    @PreAuthorize("hasAuthority('sms:categorybounds:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = categoryBoundsService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('sms:categorybounds:info')")
    public Resp<CategoryBoundsEntity> info(@PathVariable("id") Long id){
		CategoryBoundsEntity categoryBounds = categoryBoundsService.getById(id);

        return Resp.ok(categoryBounds);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('sms:categorybounds:save')")
    public Resp<Object> save(@RequestBody CategoryBoundsEntity categoryBounds){
		categoryBoundsService.save(categoryBounds);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PutMapping
    @PreAuthorize("hasAuthority('sms:categorybounds:update')")
    public Resp<Object> update(@RequestBody CategoryBoundsEntity categoryBounds){
		categoryBoundsService.updateById(categoryBounds);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @DeleteMapping
    @PreAuthorize("hasAuthority('sms:categorybounds:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		categoryBoundsService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
