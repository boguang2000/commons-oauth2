package com.sgitg.app.core.oauth2.altu.oauth2.as;

import com.sgitg.app.core.oauth2.altu.oauth2.as.request.AbstractOAuthTokenRequest;
import com.sgitg.app.core.oauth2.altu.oauth2.common.token.OAuthToken;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xkxu
 */
public class CompositeTokenGranter implements TokenGranter {

	private final List<TokenGranter> tokenGranters;

	public CompositeTokenGranter(List<TokenGranter> tokenGranters) {
		this.tokenGranters = new ArrayList<TokenGranter>(tokenGranters);
	}
	
	public OAuthToken grant(String grantType, AbstractOAuthTokenRequest tokenRequest) {
		for (TokenGranter granter : tokenGranters) {
			OAuthToken grant = granter.grant(grantType, tokenRequest);
			if (grant!=null) {
				return grant;
			}
		}
		return null;
	}
	
	public void addTokenGranter(TokenGranter tokenGranter) {
		if (tokenGranter == null) {
			throw new IllegalArgumentException("Token granter is null");
		}
		tokenGranters.add(tokenGranter);
	}
}
