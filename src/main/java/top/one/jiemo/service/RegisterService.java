package top.one.jiemo.service;

import top.one.jiemo.model.userEntity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface RegisterService {

	public void addUser(userEntity user);
	public  int findUserFromDb(String userName);
	
	
}
