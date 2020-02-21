package top.one.jiemo.service;

import top.one.jiemo.model.userEntity;

public interface UpdateEmailService {

	public int updateEmail(userEntity user);
	public String findEmail(String userName);
}