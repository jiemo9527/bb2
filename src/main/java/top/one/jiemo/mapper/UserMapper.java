package top.one.jiemo.mapper;
//用户设置
import top.one.jiemo.model.VideoEntity;
import top.one.jiemo.model.userEntity;

import java.util.List;

public interface  UserMapper {
    userEntity findDetail(String userName);//获取用户所有信息
    void addUser(userEntity user);//添加用户
    int findUserFromDb(String userName);//查找数据库是否存在用户XXX
    int checkUser(userEntity user);//查找对应（userName,UserPassword）是否有用户
    int updateLoginTime(userEntity user);//更新上次登录时间
    String findPasswd(String userName);//根据userName拿到userPassword
    int updatePassword(userEntity user);//修改用户登陆密码

    String findEmail(String userName);//根据userName拿到userEmail
    int updateEmail(userEntity user);//绑定邮箱修改
    String findPhone(String userName);//根据userName拿到userPhone
    int updatePhone(userEntity user);//绑定手机修改
    String findPayPassword(String userName);//查找支付密码
    int updatePayPassword(userEntity user);//修改支付密码
    int updateUserAddress(userEntity user);//修改用户地址
    int UpdateUserCard(userEntity user);//修改银行卡

    //读取图片用findDetail(),出现的页面：order
    int updateUserPicture(userEntity user);//将用户上传的图片存放的路径写入数据库
    int updateUserMoney(int payMoney,String username);//更新余额


}

