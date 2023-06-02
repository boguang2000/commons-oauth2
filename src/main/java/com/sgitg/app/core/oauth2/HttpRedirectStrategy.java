package com.sgitg.app.core.oauth2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xkxu
 */
public interface HttpRedirectStrategy {

	public void sendRedirect(String redirectUrl, HttpServletRequest request, HttpServletResponse response) throws IOException;
}
