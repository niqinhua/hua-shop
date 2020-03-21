/**
 * Copyright (c) 2016-2019 谷粒开源 All rights reserved.
 *
 * https://www.guli.cloud
 *
 * 版权所有，侵权必究！
 */

package com.hua.shop.gmall.core.bean;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hua.shop.gmall.core.utils.SQLFilter;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询参数
 *
 * @author Mark sunlightcs@gmail.com
 */
public class Query<T> {


    public IPage<T> getPage(QueryCondition params) {
        return this.getPage(params, null, false);
    }



    public IPage<T> getPage(QueryCondition params, String defaultOrderField, boolean isAsc) {
        //分页参数
        long curPage = 1;
        long limit = 10;

        if(params.getPage() != null){
            curPage = params.getPage();
        }
        if(params.getLimit() != null){
            limit = params.getLimit();
        }

        //分页对象
        Page<T> page = new Page<>(curPage, limit);

        //排序字段
        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String orderField = SQLFilter.sqlInject(params.getSidx());
        String order = params.getOrder();

        List<OrderItem> items =new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        if(StringUtils.isNotEmpty(orderField)){
            if (StringUtils.isNotEmpty(order)){
                if("asc".equalsIgnoreCase(order)) {
                    orderItem.setAsc(true);
                }else {
                    orderItem.setAsc(false);
                }
            }else{
                orderItem.setAsc(isAsc);
            }
            orderItem.setColumn(orderField);
            items.add(orderItem);
            page.addOrder(items);
        }
        return page;
    }





}
