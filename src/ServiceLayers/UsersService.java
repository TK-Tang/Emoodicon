package ServiceLayers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.User;
import DAO.UsersDAO;

@Service("usersService")
public class UsersService {
	
	private UsersDAO usersDAO;
	
	@Autowired
	public void setUsersDAO(UsersDAO usersDAO){
		this.usersDAO = usersDAO;
	}
	
	public void create(User user){
		usersDAO.create(user);
	};
}