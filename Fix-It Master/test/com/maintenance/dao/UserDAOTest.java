package com.maintenance.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.maintenance.entity.User;

public class UserDAOTest extends BaseDAOTest {
	public static UserDAO userDao;

	@BeforeClass
	public static void setUpBeforeClass() {
		BaseDAOTest.setUpBeforeClass();
		userDao=new UserDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass(){
		BaseDAOTest.tearDownAfterClass();
	}

	@Test
	public void testCreateUser() {
		User user1=new User();
		user1.setEmail("Maharani@gmail.com");
		user1.setFullName("Maharani");
		user1.setPassword("4567");
		user1 =userDao.create(user1);
		
		assertTrue(user1.getUserId()>0);
		
	}

	@Test
	public void testUpdate() {
		User user=new User();
		user.setUserId(104);
		user.setEmail("Maharani@gmail.com");
		user.setFullName("Maharani");
		user.setPassword("abcd");
		
		user=userDao.update(user);
		
		String expected="abcd";
		String actual=user.getPassword();
		
		assertEquals(expected, actual);
		
	}

	@Test
	public void testGetUser() {
		int userId=1;
		User user=userDao.get(userId);
		
		System.out.println("User Name is: " + user.getFullName() + " User Email is: " + user.getEmail() );
		assertNotNull(user);
		
	}
	
	@Test
	public void testGetUserNotFound() {
		int userId=9999;
		User user=userDao.get(userId);
		
		assertNull(user);
		
	}

	@Test
	public void testDeleteUser() {
		int userId=104;
		 userDao.delete(userId);
		 
		 User user= userDao.get(userId);
		 
		 assertNull(user);
		
	}

	@Test
	public void testListAll() {
		List<User> listUsers=userDao.listAll();
		
		for(User user: listUsers) {
			System.out.println(user.getFullName());
		}
		assertTrue(listUsers.size()>0);
	}

	@Test
	public void testCount() {
	
		long totalUsers=userDao.count();
		assertEquals(12, totalUsers);
	}

}
