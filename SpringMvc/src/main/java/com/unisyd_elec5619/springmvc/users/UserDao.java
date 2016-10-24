package com.unisyd_elec5619.springmvc.users;

import java.util.List;

public interface UserDao {
	
	public class UserDaoJpaImpl {

	}

	public void insert(Users user);

	public void update(Users user);

	public void update(List<Users> users);

	public void deleteUser(long userId);

	public Users find(long userId);
	

	public List<Users> find(List<Long> userIds);
	
	public boolean exists(long userId);
	
	public Users getUser(String username);


}
