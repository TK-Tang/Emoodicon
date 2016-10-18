package DAO;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("usersDAO")
public class UsersDAO {
	
	// Some template thing fed with a DataSource object from beans which refers to a class imported used for SQL connections???
	// JDBC template "wraps" DataSource
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Transactional
	public boolean create(User user){
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		System.out.println("help");
		jdbc.update("INSERT INTO users (username, password, enabled, email) VALUES (:username, :password, :enabled, :email)", params);
		
		return jdbc.update("INSERT INTO authorities (username, authority) VALUES (:username, :authority)", params) == 1;
	}
}
