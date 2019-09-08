package com.yidu.product.dao;


import com.yidu.product.domain.YiduProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YiduProductMapper {
    int deleteByPrimaryKey(String proId);

    int insert(YiduProduct record);

    int insertSelective(YiduProduct record);

    YiduProduct selectByPrimaryKey(String proId);

    int updateByPrimaryKeySelective(YiduProduct record);

    int updateByPrimaryKey(YiduProduct record);

    List<YiduProduct> findAll();
}