package top.one.jiemo.mapper;

import top.one.jiemo.model.OrderEntity;
import top.one.jiemo.model.userEntity;

import java.util.List;

public interface BSMapper {
    String  findSuPassword();//查询后台管理员密码
    List<OrderEntity> findAllOrders();//查询所有订单
    List<OrderEntity> findNoShipped();//查询未发货订单
    int ship(String orderID);//立即发货
    List<OrderEntity> findCompletedOrders();//查询已完成订单
    List<OrderEntity> findReturnOrders();//查询退货订单
    int Return(String orderID);//立即退货
    List<OrderEntity> findOrders(String orderUserName);//查询自定义订单

    List<userEntity> findAllUsers();//查询所有用户
    userEntity findUserByC1(String userName);//条件查询1
    userEntity findUserByC2(String userPhone);//条件查询2
    int ApprovedUser(String userName); //注册账号通过审核
    int FreezeUser(String userName); //非法账号冻结

}
