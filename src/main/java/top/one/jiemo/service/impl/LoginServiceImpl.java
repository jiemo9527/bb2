package top.one.jiemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.one.jiemo.mapper.UserMapper;
import top.one.jiemo.model.userEntity;
import top.one.jiemo.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public int checkUser(userEntity user) {

		return userMapper.checkUser(user);
	}
}