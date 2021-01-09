package com.bank.service.impl;

import org.apache.log4j.Logger;

import com.bank.dao.LoginDAO;
import com.bank.dao.impl.LoginDAOImpl;
import com.bank.exception.BusinessException;
import com.bank.model.Login;
import com.bank.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private static Logger log = Logger.getLogger(LoginServiceImpl.class);
	private LoginDAO loginDAO = new LoginDAOImpl();
	
	@Override
	public Login credentialVerification(String username, String password) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int newCredentials(Login login) throws BusinessException {
		int valid=0;
		try {
			if(loginDAO.newCredentials(login) !=0) {
				valid = 1;
			}
		}catch (BusinessException e) {
			log.info(e.getMessage());
		}
		return valid;
	}

}
