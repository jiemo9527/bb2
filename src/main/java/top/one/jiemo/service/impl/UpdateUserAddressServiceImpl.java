package top.one.jiemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.one.jiemo.mapper.UserMapper;
import top.one.jiemo.model.userEntity;
import top.one.jiemo.service.UpdateUserAddressService;


@Service
public class UpdateUserAddressServiceImpl implements UpdateUserAddressService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int UpdateUserAddress(userEntity user) {
        return userMapper.updateUserAddress(user);
    }
}
