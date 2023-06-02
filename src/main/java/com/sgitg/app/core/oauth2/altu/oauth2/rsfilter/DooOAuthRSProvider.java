package com.sgitg.app.core.oauth2.altu.oauth2.rsfilter;

import com.sgitg.app.core.oauth2.altu.oauth2.common.exception.OAuthProblemException;
import com.sgitg.app.core.oauth2.altu.oauth2.common.token.OAuthToken;
import com.sgitg.app.core.oauth2.altu.oauth2.common.token.TokenStore;
import com.sgitg.app.core.oauth2.altu.oauth2.common.utils.OAuthUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xkxu
 */
public class DooOAuthRSProvider implements OAuthRSProvider {
	
	private TokenStore tokenRegistry;
	
	@Override
	public OAuthDecision validateRequest(
			String rsId, String token, HttpServletRequest req) throws OAuthProblemException {
		
		OAuthToken tokenToUse = tokenRegistry.getToken(token);
		
		if (tokenToUse == null) {
			throw OAuthUtils.handleOAuthProblemException("没有找到对应的令牌");
		}
		
		if (tokenToUse.isExpired()) {
			tokenRegistry.deleteToken(tokenToUse.getAccessToken());
			
			throw OAuthUtils.handleOAuthProblemException("令牌已过期");
		}
		String uid = tokenToUse.getUid() != null ? tokenToUse.getUid() : tokenToUse.getUsername();
		return new SimpleOAuthDecision(uid, tokenToUse.getClientId());
	}

	public void setTokenRegistry(TokenStore tokenRegistry) {
		this.tokenRegistry = tokenRegistry;
	}

}
