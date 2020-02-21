package top.one.jiemo.service;

import top.one.jiemo.model.userEntity;

public interface UpdatePayPasswordService {
	String findPayPassword(String userName);
	int updatePayPassword(userEntity user);
}