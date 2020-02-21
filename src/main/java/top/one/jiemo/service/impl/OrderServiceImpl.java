package top.one.jiemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.one.jiemo.mapper.OrderMapper;
import top.one.jiemo.model.OrderEntity;
import top.one.jiemo.service.OrderService;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderEntity> findAllOrders(String userName) {
        return  orderMapper.findAllOrders(userName);
    }

    @Override
    public int cancelOrder(String OrderID) {
        return orderMapper.cancelOrder(OrderID);
    }

    @Override
    public int delOrder(String OrderID) {
        return orderMapper.delOrder(OrderID);
    }

    @Override
    public List<OrderEntity> findDelOrders(String userName) {
        return orderMapper.findDelOrders(userName);
    }

    @Override
    public int addOrders(OrderEntity order) {
        return orderMapper.addOrders(order);
    }

    @Override
    public List<Integer> findUserPaymoney(String username) {
        return orderMapper.findUserPaymoney(username);
    }


}
