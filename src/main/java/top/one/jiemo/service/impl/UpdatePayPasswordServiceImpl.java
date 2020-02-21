package top.one.jiemo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.one.jiemo.mapper.UserMapper;
import top.one.jiemo.model.userEntity;
import top.one.jiemo.service.UpdatePayPasswordService;

@Service
public class UpdatePayPasswordServiceImpl implements UpdatePayPasswordService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public String findPayPassword(String userName) {
        return userMapper.findPayPassword(userName);
    }

    @Override
    public int updatePayPassword(userEntity user) {
        return userMapper.updatePayPassword(user);
    }
}
