package com.wsj.Service;

import com.wsj.Bean.Userinfo;
import com.wsj.Util.UserServiceException;


public interface UserService {
	//注册的方法
	void registerUser(Userinfo user)throws UserServiceException;
	//登陆的方法
	Userinfo loginUser(String userid,String password)throws UserServiceException;
	//修改
	void updateUser(Userinfo user)throws UserServiceException;
}
