/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.aotcloud.oauth2.altu.oauth2.jwt.request;

import javax.servlet.http.HttpServletRequest;

import cn.aotcloud.oauth2.altu.oauth2.as.request.AbstractOAuthTokenRequest;
import cn.aotcloud.oauth2.altu.oauth2.common.OAuth;
import cn.aotcloud.oauth2.altu.oauth2.common.exception.OAuthProblemException;
import cn.aotcloud.oauth2.altu.oauth2.common.exception.OAuthSystemException;
import cn.aotcloud.oauth2.altu.oauth2.common.message.types.GrantType;
import cn.aotcloud.oauth2.altu.oauth2.common.validators.OAuthValidator;

public class JWTOAuthRequest extends AbstractOAuthTokenRequest {

    /**
     * Create a JWT OAuth Token request from a given HttpSerlvetRequest
     *
     * @param request the httpservletrequest that is validated and transformed into the JWT OAuth Token Request
     * @throws OAuthSystemException  if an unexpected exception was thrown
     * @throws OAuthProblemException if the request was not a valid Token request this exception is thrown.
     */
    public JWTOAuthRequest(HttpServletRequest request) throws OAuthSystemException, OAuthProblemException {
        super(request);
    }
    
	@Override
	protected OAuthValidator<HttpServletRequest> initValidator()
			throws OAuthProblemException, OAuthSystemException {
		validators.put(GrantType.JWT_BEARER.toString(), JWTBearerValidator.class);
		return super.initValidator();
	}
	
	public String getAssertion() {
		return getParam(OAuth.ASSERTION);
	}
}
