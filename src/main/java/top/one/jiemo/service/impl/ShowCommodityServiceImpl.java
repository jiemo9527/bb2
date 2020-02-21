package top.one.jiemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.one.jiemo.mapper.CommodityMapper;
import top.one.jiemo.model.commodityEntity;
import top.one.jiemo.service.ShowCommodityService;

import java.util.List;


@Service
public class ShowCommodityServiceImpl implements ShowCommodityService {
    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public List<commodityEntity> findAllCommodity() {
        return commodityMapper.findAllCommodity();
    }

    @Override
    public commodityEntity findCommodityById(Integer id) {
        return commodityMapper.findCommodityById(id);
    }
}
