package top.one.jiemo.mapper;

//展示商品

import top.one.jiemo.model.commodityEntity;


import java.util.List;

public interface CommodityMapper {
    List<commodityEntity> findAllCommodity();//展示商品列表
    commodityEntity findCommodityById(Integer id);//查询单个商品






}

