package com.hua.shop.pms.controller;

import com.hua.shop.gmall.core.bean.PageVo;
import com.hua.shop.gmall.core.bean.QueryCondition;
import com.hua.shop.gmall.core.bean.Resp;
import com.hua.shop.pms.entity.BrandEntity;
import com.hua.shop.pms.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;




/**
 * 品牌
 *
 * @author 倪勤华
 * @date 2020-03-19 01:00:07
 */
@Api(tags = "品牌 管理")
@RestController
@RequestMapping("pms/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/page")
    @PreAuthorize("hasAuthority('pms:brand:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = brandService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/{brandId}")
    @PreAuthorize("hasAuthority('pms:brand:info')")
    public Resp<BrandEntity> info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return Resp.ok(brand);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping
    @PreAuthorize("hasAuthority('pms:brand:save')")
    public Resp<Object> save(@RequestBody BrandEntity brand){
		brandService.save(brand);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PutMapping
    @PreAuthorize("hasAuthority('pms:brand:update')")
    public Resp<Object> update(@RequestBody BrandEntity brand){
		brandService.updateById(brand);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @DeleteMapping
    @PreAuthorize("hasAuthority('pms:brand:delete')")
    public Resp<Object> delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return Resp.ok(null);
    }

}
