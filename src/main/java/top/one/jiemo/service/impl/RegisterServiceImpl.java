package top.one.jiemo.service.impl;

import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import top.one.jiemo.mapper.UserMapper;
import top.one.jiemo.model.userEntity;
import top.one.jiemo.service.RegisterService;



@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void addUser(userEntity user) {
		userMapper.addUser(user);
	}

	@Override
	public int findUserFromDb(String userName) {
		return userMapper.findUserFromDb(userName);
	}
}
