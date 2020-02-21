package top.one.jiemo.service;

import top.one.jiemo.model.ShoppingCar;

import java.util.List;

public interface UpdateGoodsService {
    int addgoods(ShoppingCar car);
    int delgoods(String carID);
    List<ShoppingCar> findgoodsFromCar(String userName);
}
