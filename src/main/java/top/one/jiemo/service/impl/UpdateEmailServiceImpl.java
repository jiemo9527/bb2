package top.one.jiemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.one.jiemo.mapper.UserMapper;
import top.one.jiemo.model.userEntity;
import top.one.jiemo.service.UpdateEmailService;

@Service
public class UpdateEmailServiceImpl implements UpdateEmailService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int updateEmail(userEntity user) {
        return userMapper.updateEmail(user);
    }

    @Override
    public String findEmail(String userName) {
        return userMapper.findEmail(userName);
    }
}
