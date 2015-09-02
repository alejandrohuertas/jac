package jac.service;

import jac.dao.LoginDAO;
import jac.login.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

	@Autowired
	private LoginDAO loginDAO;
	
	public Login getLoginByUsername(String username){
		
		return loginDAO.getLoginByUsername(username);
	}
}
