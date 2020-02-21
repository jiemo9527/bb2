package top.one.jiemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.one.jiemo.mapper.UserMapper;
import top.one.jiemo.model.userEntity;
import top.one.jiemo.service.UpdateUserCardService;


@Service
public class UpdateUserCardServiceImpl implements UpdateUserCardService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int UpdateUserCard(userEntity user) {
        return userMapper.UpdateUserCard(user);
    }
}
