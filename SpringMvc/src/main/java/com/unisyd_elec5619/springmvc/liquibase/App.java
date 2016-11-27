package com.unisyd_elec5619.springmvc.liquibase;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;

import liquibase.integration.spring.SpringLiquibase;

public class App {

	public BasicDataSource dataSource(){
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("24157817");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
		dataSource.setMaxActive(130);
		dataSource.setMaxIdle(5);
		dataSource.setInitialSize(5);
		
		return dataSource;
	}

	@Bean
	public SpringLiquibase liquibase() {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setChangeLog("classpath:liquibase-changeLog.xml");
		liquibase.setDataSource(dataSource());
		return liquibase;
	}

}
