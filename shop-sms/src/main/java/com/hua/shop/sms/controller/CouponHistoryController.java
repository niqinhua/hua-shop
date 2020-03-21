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

import com.hua.shop.sms.entity.CouponHistoryEntity;
import com.hua.shop.sms.service.CouponHistoryService;




/**
 * 优惠券领取历史记录
 *
 * @author 倪勤华
 * @date 2020-03-21 13:09:50
 */
@Api(tags = "优惠券领取历史记录 管理")
@RestController
@RequestMapping("sms/couponhistory")
public class CouponHistoryController {
    @Autowired
    private CouponHistoryService couponHistoryService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/page")
    @PreAuthorize("hasAuthority('sms:couponhistory:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = couponHistoryService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('sms:couponhistory:info')")
    public Resp<CouponHistoryEntity> info(@PathVariable("id") Long id){
		CouponHistoryEntity couponHistory = couponHistoryService.getById(id);

        return Resp.ok(couponHistory);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('sms:couponhistory:save')")
    public Resp<Object> save(@RequestBody CouponHistoryEntity couponHistory){
		couponHistoryService.save(couponHistory);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PutMapping
    @PreAuthorize("hasAuthority('sms:couponhistory:update')")
    public Resp<Object> update(@RequestBody CouponHistoryEntity couponHistory){
		couponHistoryService.updateById(couponHistory);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @DeleteMapping
    @PreAuthorize("hasAuthority('sms:couponhistory:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		couponHistoryService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
