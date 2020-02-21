package top.one.jiemo.service;

import top.one.jiemo.model.userEntity;

public interface UserInformationShowService {
	int updateUserMoney(int payMoney,String username);//更新余额
	userEntity findDetail(String userName);
	int updateLoginTime(userEntity user);
}
