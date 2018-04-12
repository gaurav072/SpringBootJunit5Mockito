package mypack;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import mypack.beans.User;
import mypack.dao.UserDao;
import mypack.service.UserServiceImpl;
@RunWith(MockitoJUnitRunner.class)
public class MockitoJunitExample {
	@Mock
	UserDao	dao;
	@InjectMocks
	UserServiceImpl service;	
	@Before
	public void m1() {
		when(service.login("gaurav", "124")).thenReturn(new User());
	}
	
	@Test
	public void test1() {	
		System.out.println(service);
		System.out.println(service.login("gaurav", "1234"));
		assertNotNull("Obj is not null",dao.auth("gaurav", "1245"));
	}
	
}
