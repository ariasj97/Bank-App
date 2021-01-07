package com.bank.dao;

import com.bank.model.Customer;
import com.bank.model.Login;
import com.bank.exception.BusinessException;

public interface LoginDAO {
	public Login credentialVerification(String username,String password) throws BusinessException;
}
