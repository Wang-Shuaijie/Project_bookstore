package com.wsj.Dao;

import com.wsj.Bean.Userinfo;

public interface UserDao {
	//�������
	void saveUser(Userinfo user);
	//�������ֲ�ѯ����
	Userinfo findUserByUserId(String userid);
	//�޸��û���Ϣ
	void updateUserByUserId(Userinfo user);
}
