package service;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class UserService {

	public UserService() {
		// TODO Auto-generated constructor stub
	}
	//删除类
	public boolean deleteUser(String name) {
		// TODO Auto-generated method stub
		UserDao dao=new UserDaoImpl();
		User u=dao.findByName(name);
		if(u!=null){
			dao.deleteByName(name);
			return true;
		}else{
			return false;
					
		}
	
	}

}
