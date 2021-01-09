package com.bank.service;

import com.bank.dao.LoginDAO;
import com.bank.exception.BusinessException;
import com.bank.model.Login;

public interface LoginService  {
	public Login credentialVerification(String username,String password) throws BusinessException;
	public int newCredentials(Login login)throws BusinessException;
}
