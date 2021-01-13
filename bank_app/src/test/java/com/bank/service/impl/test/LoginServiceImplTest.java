package com.bank.service.impl.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bank.exception.BusinessException;
import com.bank.model.Login;
import com.bank.service.LoginService;
import com.bank.service.impl.LoginServiceImpl;

class LoginServiceImplTest {

private static LoginService app;
	
	@BeforeAll
	public static void setUp() {
		app = new LoginServiceImpl();
	}
	
    @Test
	public  void newCredentialsTest() throws BusinessException{
			Login output = new Login();
			output.setUsername("random246");
			output.setPassword("pasword246");
			output.setUser_id(1001);
			assertEquals(1,app.newCredentials(output));
	}

}
