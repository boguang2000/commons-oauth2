package com.sgitg.app.core.oauth2.altu.oauth2.as;

import com.sgitg.app.core.oauth2.altu.oauth2.as.request.AbstractOAuthTokenRequest;
import com.sgitg.app.core.oauth2.altu.oauth2.common.token.OAuthToken;

/**
 * @author xkxu
 */
public interface TokenGranter {

	OAuthToken grant(String grantType, AbstractOAuthTokenRequest tokenRequest);
}
