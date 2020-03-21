package com.hua.shop.pms.dao;

import com.hua.shop.pms.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author 倪勤华
 * @date 2020-03-19 01:00:06
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
