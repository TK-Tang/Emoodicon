package com.unisyd_elec5619.springmvc;

import java.util.List;

public interface UserDao {	

	
	    public class UserDaoJpaImpl {

	}

		public void insert(User user);

	    public void update(User user);

	    public void update(List<User> users);

	    public void delete(long userId);

	    public User find(long userId);

	    public List<User> find(List<Long> userIds);
	
}
