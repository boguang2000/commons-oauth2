package com.sgitg.app.core.oauth2.altu.oauth2.rs.extractor;


import com.sgitg.app.core.oauth2.altu.oauth2.common.OAuth;
import com.sgitg.app.core.oauth2.altu.oauth2.common.utils.OAuthUtils;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 * @author xkxu
 *
 */
public class BearerCookieTokenExtractor implements TokenExtractor {
	
	@Override
	public String getAccessToken(HttpServletRequest request) {
		return getAccessToken(request, OAuth.Cookie.COOKIE_NAME);
	}

	@Override
	public String getAccessToken(HttpServletRequest request, String tokenName) {
		return getCookieValue(request, tokenName);
	}

	protected String getCookieValue(HttpServletRequest request, String cookieName) {
		return OAuthUtils.getCookieValue(request, cookieName);
	}
}
