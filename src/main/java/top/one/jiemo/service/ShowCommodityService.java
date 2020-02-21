package top.one.jiemo.service;

import top.one.jiemo.model.commodityEntity;

import java.util.List;

public interface ShowCommodityService {
    List<commodityEntity> findAllCommodity();
    commodityEntity findCommodityById(Integer id);
}
