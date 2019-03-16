package com.wsj.Dao;

import com.wsj.Bean.Userinfo;

public interface UserDao {
	//保存对象
	void saveUser(Userinfo user);
	//基于名字查询对象
	Userinfo findUserByUserId(String userid);
	//修改用户信息
	void updateUserByUserId(Userinfo user);
}
