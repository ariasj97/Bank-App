package com.bank.dao;

import com.bank.model.Login;
import com.bank.exception.BusinessException;

public interface LoginDAO {
	public Login credentialVerification(String username,String password) throws BusinessException;
	public int newCredentials(Login login)throws BusinessException;
}
