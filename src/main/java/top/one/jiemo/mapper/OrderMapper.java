package top.one.jiemo.mapper;

import top.one.jiemo.model.OrderEntity;

import java.util.List;

//用户管理订单
public interface OrderMapper {

    List<OrderEntity> findAllOrders(String userName);//查询所有订单
    int cancelOrder(String OrderID);//取消订单
    int delOrder(String OrderID);//删除订单
    List<OrderEntity> findDelOrders(String userName);//查询用户已删除订单
    int addOrders(OrderEntity order);// 添加订单
    List<Integer> findUserPaymoney(String username);//查询用户消费

}
