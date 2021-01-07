package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bank.dao.LoginDAO;
import com.bank.dao.dbutil.PostgresqlConnection;
import com.bank.exception.BusinessException;
import com.bank.main.bankMain;
import com.bank.model.Customer;
import com.bank.model.Login;

public class LoginDAOImpl implements LoginDAO {
	private static Logger log = Logger.getLogger(LoginDAOImpl.class);

	@Override
	public Login credentialVerification(String username, String password) throws BusinessException {
		Login login = null;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "select user_id, username,password from public.login where username=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2,password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				login = new Login();
				login.setUser_id(resultSet.getInt("user_id"));
				login.setUsername(username);
				login.setPassword(password);
			}else {
				throw new BusinessException("No combination of inputted username and password found");
			}
		}catch(ClassNotFoundException | SQLException e) {
			log.info(e);
			throw new BusinessException("internal error occured contact sysadmin");
		}
		
		return login;
	}
}
