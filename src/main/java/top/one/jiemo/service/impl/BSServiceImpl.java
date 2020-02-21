package top.one.jiemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.one.jiemo.mapper.BSMapper;
import top.one.jiemo.model.OrderEntity;
import top.one.jiemo.model.userEntity;
import top.one.jiemo.service.BSService;

import java.util.List;


@Service
public class BSServiceImpl implements BSService {
    @Autowired
    private BSMapper bsMapper;

    @Override
    public String findSuPassword() {
       return bsMapper.findSuPassword();
    }

    @Override
    public List<OrderEntity> findAllOrders() {
        return bsMapper.findAllOrders();
    }

    @Override
    public List<OrderEntity> findNoShipped() {
        return bsMapper.findNoShipped();
    }

    @Override
    public int ship(String orderID) {
        return bsMapper.ship(orderID);
    }

    @Override
    public List<OrderEntity> findCompletedOrders() {
        return bsMapper.findCompletedOrders();
    }

    @Override
    public List<OrderEntity> findReturnOrders() {
        return bsMapper.findReturnOrders();
    }

    @Override
    public int Return(String orderID) {
        return bsMapper.Return(orderID);
    }

    @Override
    public List<OrderEntity> findOrders(String orderUserName) {
        return bsMapper.findOrders(orderUserName);
    }

    @Override
    public List<userEntity> findAllUsers() {
        return bsMapper.findAllUsers();
    }

    @Override
    public userEntity findUserByC1(String userName) {
        return bsMapper.findUserByC1(userName);
    }

    @Override
    public userEntity findUserByC2(String userPhone) {
        return bsMapper.findUserByC2(userPhone);
    }

    @Override
    public int ApprovedUser(String userName) {
        return bsMapper.ApprovedUser(userName);
    }

    @Override
    public int FreezeUser(String userName) {
        return bsMapper.FreezeUser(userName);
    }
}
