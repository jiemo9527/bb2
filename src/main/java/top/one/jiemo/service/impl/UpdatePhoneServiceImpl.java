package top.one.jiemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.one.jiemo.mapper.UserMapper;
import top.one.jiemo.model.userEntity;
import top.one.jiemo.service.UpdatePhoneService;

@Service
public class UpdatePhoneServiceImpl implements UpdatePhoneService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int updatePhone(userEntity user) {
        return userMapper.updatePhone(user);
    }

    @Override
    public String findPhone(String userName) {
        return userMapper.findPhone(userName);
    }
}
