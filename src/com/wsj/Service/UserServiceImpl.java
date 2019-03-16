package com.wsj.Service;

import com.wsj.Bean.Userinfo;
import com.wsj.Dao.UserDao;
import com.wsj.Dao.UserDaoImpl;
import com.wsj.Util.UserServiceException;


public class UserServiceImpl implements UserService{
	
	private UserDao dao=new UserDaoImpl();

	@Override
	public void registerUser(Userinfo user) throws UserServiceException {
		// TODO Auto-generated method stub
		Userinfo u=dao.findUserByUserId(user.getUserid());
		if(u!=null){
			throw new UserServiceException("用户名已经存在");
		}
		dao.saveUser(user);
	}

	@Override
	public Userinfo loginUser(String userid, String password)
			throws UserServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(Userinfo user) throws UserServiceException {
		// TODO Auto-generated method stub
		dao.updateUserByUserId(user);
	}

}
