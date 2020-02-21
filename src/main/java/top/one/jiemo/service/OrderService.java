package top.one.jiemo.service;

import top.one.jiemo.model.OrderEntity;

import java.util.List;

public interface OrderService {
    List<OrderEntity> findAllOrders(String userName);
    int cancelOrder(String OrderID);
    int delOrder(String OrderID);
    List<OrderEntity> findDelOrders(String userName);
    int addOrders(OrderEntity order);
    List<Integer> findUserPaymoney(String username);
}
