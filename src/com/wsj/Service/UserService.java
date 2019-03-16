package com.wsj.Service;

import com.wsj.Bean.Userinfo;
import com.wsj.Util.UserServiceException;


public interface UserService {
	//ע��ķ���
	void registerUser(Userinfo user)throws UserServiceException;
	//��½�ķ���
	Userinfo loginUser(String userid,String password)throws UserServiceException;
	//�޸�
	void updateUser(Userinfo user)throws UserServiceException;
}
