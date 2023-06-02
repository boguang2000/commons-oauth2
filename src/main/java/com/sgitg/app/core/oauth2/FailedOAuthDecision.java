package com.sgitg.app.core.oauth2;


import com.sgitg.app.core.oauth2.altu.oauth2.common.exception.OAuthProblemException;
import com.sgitg.app.core.oauth2.altu.oauth2.rsfilter.OAuthClient;
import com.sgitg.app.core.oauth2.altu.oauth2.rsfilter.OAuthDecision;

import java.security.Principal;

/**
 * 
 * @author xkxu
 *
 */
public class FailedOAuthDecision implements OAuthDecision {

	private OAuthProblemException e;

	public FailedOAuthDecision(OAuthProblemException e) {
		this.e = e;
	}

	@Override
	public boolean isAuthorized() {
		return false;
	}

	@Override
	public Principal getPrincipal() {
		return null;
	}

	@Override
	public OAuthClient getOAuthClient() {
		return null;
	}

	public OAuthProblemException getThrowable() {
		return e;
	}
}
