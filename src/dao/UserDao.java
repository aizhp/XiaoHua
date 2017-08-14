package dao;

import entity.User;

public interface UserDao {
	public void deleteByName(String name);//dao接口

	public User findByName(String name);
}
