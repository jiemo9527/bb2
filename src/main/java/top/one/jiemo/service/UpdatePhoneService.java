package top.one.jiemo.service;

import top.one.jiemo.model.userEntity;

public interface UpdatePhoneService {

	public int updatePhone(userEntity user);
	public String findPhone(String userName);
}