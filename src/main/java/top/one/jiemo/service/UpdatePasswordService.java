package top.one.jiemo.service;

import top.one.jiemo.model.userEntity;

public interface UpdatePasswordService {

	public String findPasswd(String userName);
	public int updatePassword(userEntity user);
}