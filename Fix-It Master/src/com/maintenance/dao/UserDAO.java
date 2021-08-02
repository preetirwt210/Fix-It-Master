package com.maintenance.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.maintenance.entity.User;

public class UserDAO extends JpaDAO<User> implements GenericDAO<User>{

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public User create(User user) {
		
		return super.create(user);
	}


	@Override
	public User update(User user) {
		
		return super.update(user);
	}

	@Override
	public User get(Object userId) {
		return super.find(User.class,userId );
	}

	@Override
	public void delete(Object userId) {
		super.delete(User.class, userId);
		
	}

	@Override
	public List<User> listAll() {
		return super.findWithNamedQuery("User.findAll");
	}

	public boolean checkLogin() {
		return false;
	}
	
	public User findByEmail(String email) {
		return (User) super.findWithNamedQuery("User.findByEmail");
	}
	@Override
	public long count() {
		return super.countWithNamedQuery("User.countAll");
	}

	
}
