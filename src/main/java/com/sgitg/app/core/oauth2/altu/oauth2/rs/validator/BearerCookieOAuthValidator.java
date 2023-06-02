package com.sgitg.app.core.oauth2.altu.oauth2.rs.validator;

import com.sgitg.app.core.oauth2.altu.oauth2.common.OAuth;
import com.sgitg.app.core.oauth2.altu.oauth2.common.error.OAuthError;
import com.sgitg.app.core.oauth2.altu.oauth2.common.exception.OAuthProblemException;
import com.sgitg.app.core.oauth2.altu.oauth2.common.utils.OAuthUtils;
import com.sgitg.app.core.oauth2.altu.oauth2.common.validators.AbstractValidator;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 * @author xkxu
 *
 */
public class BearerCookieOAuthValidator extends AbstractValidator<HttpServletRequest> {

	@Override
    public void validateContentType(HttpServletRequest request) throws OAuthProblemException {
    }

    @Override
    public void validateMethod(HttpServletRequest request) throws OAuthProblemException {
    }
    
	@Override
	public void validateRequiredParameters(HttpServletRequest request) throws OAuthProblemException {
		String value = OAuthUtils.getCookieValue(request, OAuth.Cookie.COOKIE_NAME);
		
		if (OAuthUtils.isEmpty(value)) {
            throw OAuthProblemException.error(
            		OAuthError.ResourceResponse.INVALID_REQUEST, "Missing access Token Cookie.");
        }
	}
}
