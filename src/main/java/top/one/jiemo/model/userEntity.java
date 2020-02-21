package top.one.jiemo.model;

import java.util.HashMap;
import java.util.Map;

public class userEntity {
	private String userName;//用户名
	private String passWord;//密码
	private String userEmail;//邮箱
 	private String userPhone;//手机
	private String userCard;//银行卡号
	private String sex;//性别
	private String picture;//头像
	private String userAddress;//地址
	private String userQQ;//qq
	private String userCollection;//收藏
	private String userState;//状态
	private String lastLoginTime;//最后登录时间
	private String userPayPassword;//支付密码
	private String userMoney;//用户余额

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserCard() {
		return userCard;
	}

	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserQQ() {
		return userQQ;
	}

	public void setUserQQ(String userQQ) {
		this.userQQ = userQQ;
	}

	public String getUserCollection() {
		return userCollection;
	}

	public void setUserCollection(String userCollection) {
		this.userCollection = userCollection;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getUserPayPassword() {
		return userPayPassword;
	}

	public void setUserPayPassword(String userPayPassword) {
		this.userPayPassword = userPayPassword;
	}

	public String getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(String userMoney) {
		this.userMoney = userMoney;
	}

	public userEntity() {
	}
	//登录提交
	public userEntity(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}

//	public userEntity(String userName, String passWord,String userEmail,String userPhone) {
//		this.userName = userName;
//		this.passWord = passWord;
//		this.userEmail = userEmail;
//		this.userPhone = userPhone;
//	}
	//用户详情
	public userEntity(String userName, String passWord, String userEmail, String userPhone, String userCard, String sex, String picture, String userAddress, String userQQ, String userCollection, String userState, String lastLoginTime, String userPayPassword, String userMoney) {
		this.userName = userName;
		this.passWord = passWord;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userCard = userCard;
		this.sex = sex;
		this.picture = picture;
		this.userAddress = userAddress;
		this.userQQ = userQQ;
		this.userCollection = userCollection;
		this.userState = userState;
		this.lastLoginTime = lastLoginTime;
		this.userPayPassword = userPayPassword;
		this.userMoney = userMoney;
	}

	@Override
	public String toString() {
		return "userEntity{" +
				"userName='" + userName + '\'' +
				", passWord='" + passWord + '\'' +
				", userEmail='" + userEmail + '\'' +
				", userPhone='" + userPhone + '\'' +
				", userCard='" + userCard + '\'' +
				", sex='" + sex + '\'' +
				", picture='" + picture + '\'' +
				", userAddress='" + userAddress + '\'' +
				", userQQ='" + userQQ + '\'' +
				", userCollection='" + userCollection + '\'' +
				", userState='" + userState + '\'' +
				", lastLoginTime='" + lastLoginTime + '\'' +
				", userPayPassword='" + userPayPassword + '\'' +
				", userMoney='" + userMoney + '\'' +
				'}';
	}
}
