package top.one.jiemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.one.jiemo.mapper.UserMapper;
import top.one.jiemo.model.userEntity;
import top.one.jiemo.service.UpdatePictureService;

@Service
public class UpdatePictureServiceImpl implements UpdatePictureService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int updateUserPicture(userEntity user) {
        return userMapper.updateUserPicture(user);
    }
}
