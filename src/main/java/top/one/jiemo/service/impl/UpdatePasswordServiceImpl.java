package top.one.jiemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import top.one.jiemo.mapper.UserMapper;
import top.one.jiemo.model.userEntity;
import top.one.jiemo.service.UpdatePasswordService;


//@Component
@Service
public class UpdatePasswordServiceImpl implements UpdatePasswordService {

	@Autowired
	private UserMapper userMapper;


	@Override
	public String findPasswd(String userName) {
		return userMapper.findPasswd(userName);
	}

	@Override
	public int updatePassword(userEntity user) {
		return userMapper.updatePassword(user);
	}
}
