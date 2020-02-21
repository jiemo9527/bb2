package top.one.jiemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.one.jiemo.mapper.GoodsMapper;
import top.one.jiemo.model.ShoppingCar;
import top.one.jiemo.service.UpdateGoodsService;

import java.util.List;


@Service
public class UpdateGoodsServiceImpl implements UpdateGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public int addgoods(ShoppingCar car) {
        return goodsMapper.addgoods(car);
    }

    @Override
    public int delgoods(String carID) {
        return goodsMapper.delgoods(carID);
    }

    @Override
    public List<ShoppingCar> findgoodsFromCar(String userName) {
        return goodsMapper.findgoodsFromCar(userName);
    }
}
