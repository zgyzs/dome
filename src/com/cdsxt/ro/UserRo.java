package com.cdsxt.ro;

import java.io.Serializable;

/**
 * 包含前台和后台的用户信息
 */
public class UserRo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private Integer userId;//id
	private String userType;//类型：backUser或frontUser
	private	String userName;//名字
	/**
	 * --------------
	 */
	//其他信息：用户名，密码，邮箱，手机。。。
	private String uname;//账号
	private String pwd;//密码
	/**
	 * --------------
	 */
	//是否在线-前台使用
	private boolean online;
	
	public UserRo() {
		
	}
	
	public UserRo(Integer userId, String userType) {
		super();
		this.userId = userId;
		this.userType = userType;
	}


	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}
	
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userName=" + userName
				+ ", userType=" + userType + ", uname=" + uname + ", pwd="
				+ pwd + "]";
	}

	/**
	 * 用户id和用户类型作为=唯一标志
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((userType == null) ? 0 : userType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRo other = (UserRo) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}
	
	
	
}
