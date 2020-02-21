package top.one.jiemo.service;

import top.one.jiemo.model.OrderEntity;
import top.one.jiemo.model.userEntity;

import java.util.List;

public interface BSService {

    String  findSuPassword();
    List<OrderEntity> findAllOrders();
    List<OrderEntity> findNoShipped();
    int ship(String orderID);
    List<OrderEntity> findCompletedOrders();
    List<OrderEntity> findReturnOrders();
    int Return(String orderID);
    List<OrderEntity> findOrders(String orderUserName);

    List<userEntity> findAllUsers();
    userEntity findUserByC1(String userName);
    userEntity findUserByC2(String userPhone);
    int ApprovedUser(String userName);
    int FreezeUser(String userName);

}
