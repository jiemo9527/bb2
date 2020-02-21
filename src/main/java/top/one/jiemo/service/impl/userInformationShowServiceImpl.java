package top.one.jiemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.one.jiemo.mapper.UserMapper;
import top.one.jiemo.model.userEntity;
import top.one.jiemo.service.UserInformationShowService;
/*登录成功是显示用户信息（用户名，余额，上次登录时间）*/

@Service
public class userInformationShowServiceImpl implements UserInformationShowService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public int updateUserMoney(int payMoney, String username) {
        return userMapper.updateUserMoney(payMoney,username);
    }

    @Override
    public userEntity findDetail(String userName) {
        return userMapper.findDetail(userName);
    }

    @Override
    public int updateLoginTime(userEntity user) {
        return userMapper.updateLoginTime(user);
    }
}
