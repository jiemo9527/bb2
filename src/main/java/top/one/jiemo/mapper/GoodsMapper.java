package top.one.jiemo.mapper;

//购物车物品:单用户
import top.one.jiemo.model.ShoppingCar;

import java.util.List;

public interface GoodsMapper {
    int addgoods(ShoppingCar car);//购物车添加商品
    int delgoods(String carID);//删除购物车商品
    List<ShoppingCar> findgoodsFromCar(String userName);//查看购物车



}

