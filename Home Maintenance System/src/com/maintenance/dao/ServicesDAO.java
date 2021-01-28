package com.maintenance.dao;

import javax.sql.DataSource;

public class ServicesDAO {

private DataSource dataSource;
	
	public ServicesDAO(DataSource theDataSource) {
		dataSource=theDataSource;
	}
}
