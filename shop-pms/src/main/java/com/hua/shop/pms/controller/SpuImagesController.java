package com.hua.shop.pms.controller;

import com.hua.shop.gmall.core.bean.PageVo;
import com.hua.shop.gmall.core.bean.QueryCondition;
import com.hua.shop.gmall.core.bean.Resp;
import com.hua.shop.pms.entity.SpuImagesEntity;
import com.hua.shop.pms.service.SpuImagesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;




/**
 * spu图片
 *
 * @author 倪勤华
 * @date 2020-03-19 01:00:06
 */
@Api(tags = "spu图片 管理")
@RestController
@RequestMapping("pms/spuimages")
public class SpuImagesController {
    @Autowired
    private SpuImagesService spuImagesService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/page")
    @PreAuthorize("hasAuthority('pms:spuimages:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = spuImagesService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('pms:spuimages:info')")
    public Resp<SpuImagesEntity> info(@PathVariable("id") Long id){
		SpuImagesEntity spuImages = spuImagesService.getById(id);

        return Resp.ok(spuImages);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping
    @PreAuthorize("hasAuthority('pms:spuimages:save')")
    public Resp<Object> save(@RequestBody SpuImagesEntity spuImages){
		spuImagesService.save(spuImages);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PutMapping
    @PreAuthorize("hasAuthority('pms:spuimages:update')")
    public Resp<Object> update(@RequestBody SpuImagesEntity spuImages){
		spuImagesService.updateById(spuImages);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @DeleteMapping
    @PreAuthorize("hasAuthority('pms:spuimages:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		spuImagesService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
