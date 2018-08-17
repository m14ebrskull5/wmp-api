package com.wmp.api.login.service;

import javax.servlet.http.HttpSession;

public interface LoginService {

	String getToken(String code, HttpSession session);

	String getSession(String token);
	
	boolean toAuthorize(String token);
}
