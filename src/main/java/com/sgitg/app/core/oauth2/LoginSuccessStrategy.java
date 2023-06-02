package com.sgitg.app.core.oauth2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sgitg.app.core.oauth2.filter.BaseAuthenticationFilter.AuthType;

import java.io.IOException;

/**
 * @author xkxu
 */
public interface LoginSuccessStrategy {
	
	public void onSuccess(HttpServletRequest request, HttpServletResponse response, String resource, Object accessToken, AuthType authType) throws IOException;
}
